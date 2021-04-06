package com.my.mybatisstudy;

import com.my.mybatisstudy.annotation.JsonTypeScan;
import com.my.mybatisstudy.annotation.TestInjectClass;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = "com.my.mybatisstudy")
//@JsonTypeScan("com.my.mybatisstudy")
@TestInjectClass
@EnableConfigurationProperties
public class MybatisStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStudyApplication.class, args);
    }

}
