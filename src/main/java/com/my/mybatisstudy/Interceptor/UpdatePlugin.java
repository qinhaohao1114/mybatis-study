package com.my.mybatisstudy.Interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.Properties;

@Intercepts({@Signature(method = "update",type = Executor.class,args = {MappedStatement.class,Object.class}),
@Signature(method = "update",type = StatementHandler.class,args = {Statement.class})})
@Component
public class UpdatePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("1111");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("将要包装的目标对象："+target.getClass().getName());
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
