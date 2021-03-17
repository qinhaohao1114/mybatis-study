package com.my.mybatisstudy.config;

import com.my.mybatisstudy.MybatisConfig;
import com.my.mybatisstudy.pojo.TestInjectClass;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class TestInjectClassConfig implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(TestInjectClass.class);
        definition.setScope(BeanDefinition.SCOPE_SINGLETON);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.my.mybatisstudy.pojo.Student");
        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, "testInjectClass", null);
        BeanDefinitionReaderUtils.registerBeanDefinition(holder,registry);
    }
}
