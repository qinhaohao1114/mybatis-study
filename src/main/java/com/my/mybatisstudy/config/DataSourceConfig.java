package com.my.mybatisstudy.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: QinHaoHao
 * @Description:
 * @Date: Created in 19:10 2021/4/1
 * @Modifed By:
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(ConfigurationDataSource dataSource){
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dataSource.getDriverClassName());
        hikariDataSource.setJdbcUrl(dataSource.getUrl());
        hikariDataSource.setUsername(dataSource.getUsername());
        hikariDataSource.setPassword(dataSource.getPassword());
        hikariDataSource.setConnectionTimeout(dataSource.getConnectionTimeout());
        hikariDataSource.setIdleTimeout(dataSource.getIdleTimeout());
        hikariDataSource.setMaxLifetime(dataSource.getMaxLifetime());
        hikariDataSource.setMaximumPoolSize(dataSource.getMaximumPoolSize());
        hikariDataSource.setMinimumIdle(dataSource.getMinimumIdle());
        hikariDataSource.setPoolName(dataSource.getPoolName());
        hikariDataSource.setConnectionTestQuery(dataSource.getConnectionTestQuery());
        return hikariDataSource;
    }

}
