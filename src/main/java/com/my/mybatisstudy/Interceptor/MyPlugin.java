package com.my.mybatisstudy.Interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

@Intercepts(value = {@Signature(type = ResultSetHandler.class,method = "handleResultSets" ,args = {Statement.class}),@Signature(type = StatementHandler.class,
        method = "prepare",args = {Connection.class,Integer.class}),
        @Signature(method = "update",type = Executor.class,args = {MappedStatement.class,Object.class}),
        @Signature(method = "update",type = StatementHandler.class,args = {Statement.class})})
//@Component
public class MyPlugin implements Interceptor {

    public MyPlugin() {
        System.out.println("初始化MyPlugin");
    }

    //这里是每次执行操作的时候，都会进入这个拦截器的方法内
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("对方法进行类增强...");
        return invocation.proceed();
    }

    /**
     * //主要是为了把这个拦截器生成一个代理放到拦截器链中
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("将要包装的目标对象："+target.getClass().getName());
        return Plugin.wrap(target,this);
    }

    /**
     * 获取配置文件的属性
     * 插件初始化的时候调用，也只调用一次，插件配置的属性从这里设置进来
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的初始化参数："+properties);
    }
}
