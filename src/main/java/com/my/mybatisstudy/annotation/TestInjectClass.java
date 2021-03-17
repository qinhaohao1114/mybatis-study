package com.my.mybatisstudy.annotation;

import com.my.mybatisstudy.MybatisConfig;
import com.my.mybatisstudy.config.TestInjectClassConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(TestInjectClassConfig.class)
public @interface TestInjectClass {

}