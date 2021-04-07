package com.my.mybatisstudy.durid;/**
 * @Author: QinHaoHao
 * @Description:
 * @Date: Created in 15:01 2021/4/6
 * @Modifed By:
 */

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.expr.SQLPropertyExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.util.StringUtils;

import java.util.List;

/**
 * @Author qxj
 * @Date 2021/4/6 15:01
 **/
public class ParseSql {

    public static String convertInsertsql(String sql) {
//        MySqlStatementParser parser = new MySqlStatementParser(sql);
//        SQLStatement sqlStatement = parser.parseStatement();
//        SQLParserUtils.createSQLStatementParser(sql, JdbcConstants.MYSQL);
        //1、获取抽象语法树
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        SQLStatement sqlStatement = sqlStatements.get(0);
        return null;
    }

    public static String convertSelectSql(String sql) {
        //1、获取抽象语法树
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        SQLStatement sqlStatement = sqlStatements.get(0);
        SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;
        SQLSelect select = sqlSelectStatement.getSelect();
        return null;
    }

    public void checkSelect(SQLSelect sqlSelect) {
        SQLSelectQuery query = sqlSelect.getQuery();
        if (query instanceof SQLSelectQueryBlock) {
            SQLSelectQueryBlock queryBlock = (SQLSelectQueryBlock) query;
            SQLTableSource from = queryBlock.getFrom();

        }
    }

    public void checkSqlSelectQueryBlock(SQLSelectQueryBlock queryBlock,SQLTableSource from){
        SQLExpr where = queryBlock.getWhere();
        if (from instanceof SQLExprTableSource){
            String rowCloumnName = SQLUtils.normalize("tenantId");
            String tableAlias = from.getAlias();
            String columnName = StringUtils.isEmpty(tableAlias)?rowCloumnName:tableAlias+"."+rowCloumnName;
            if (checkConditionExist(where,columnName)){
                return;
            }
        }
    }

    private boolean checkConditionExist(SQLExpr condition,String columnName){
        if (condition==null){
            return false;
        }
        if (condition instanceof SQLBinaryOpExpr){
            SQLBinaryOpExpr c1= (SQLBinaryOpExpr) condition;
            if (checkConditionExist(c1.getLeft(),columnName)){
                return false;
            }
            return checkConditionExist(c1.getRight(),columnName);
        }else if (condition instanceof SQLIdentifierExpr){
            SQLIdentifierExpr column= (SQLIdentifierExpr) condition;
            return column.normalizedName().equalsIgnoreCase(SQLUtils.normalize(columnName));
        }else if (condition instanceof SQLPropertyExpr){
            SQLPropertyExpr column= (SQLPropertyExpr) condition;
            return column.normalizedName().equalsIgnoreCase(SQLUtils.normalize(columnName));
        }else {
            return false;
        }
    }
}
