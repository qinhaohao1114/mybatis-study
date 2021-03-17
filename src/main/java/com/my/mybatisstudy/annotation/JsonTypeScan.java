package com.my.mybatisstudy.annotation;

import com.my.mybatisstudy.MybatisConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MybatisConfig.class)
public @interface JsonTypeScan {

   String[] value() default {};

   String[] basePackages() default {};

   Class<?>[] basePackageClasses() default {};

}