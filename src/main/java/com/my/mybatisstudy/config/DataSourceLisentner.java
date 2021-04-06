package com.my.mybatisstudy.config;/**
 * @Author: QinHaoHao
 * @Description:
 * @Date: Created in 10:31 2021/4/6
 * @Modifed By:
 */


import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

@Component
public class DataSourceLisentner implements ApplicationListener<EnvironmentChangeEvent> {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private ConfigurationDataSource dataSourceConfiguration;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        Set<String> keys = event.getKeys();
        if (!isChange(keys)){
            return;
        }
        Configuration configuration = sqlSessionFactory.getConfiguration();
        Environment environment = configuration.getEnvironment();
        DataSource dataSource = new DataSourceConfig().dataSource(dataSourceConfiguration);
        Class<? extends Environment> aClass = environment.getClass();
        try {
            Field dataSourceField = aClass.getDeclaredField("dataSource");
            dataSourceField.setAccessible(true);
            dataSourceField.set(environment,dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isChange(Set<String> keys){
        Class<ConfigurationDataSource> configurationDataSourceClass = ConfigurationDataSource.class;
        ConfigurationProperties annotation = configurationDataSourceClass.getAnnotation(ConfigurationProperties.class);
        String value = annotation.value();
        for (String key : keys) {
            if (key.startsWith(value)){
                return true;
            }
        }
        return false;
    }
}
