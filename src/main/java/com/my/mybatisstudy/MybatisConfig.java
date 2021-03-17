package com.my.mybatisstudy;

import com.my.mybatisstudy.annotation.JsonTypeHandle;
import com.my.mybatisstudy.annotation.JsonTypeScan;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

public class MybatisConfig implements ImportBeanDefinitionRegistrar , ResourceLoaderAware, EnvironmentAware {

    private ResourceLoader resourceLoader;

    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        // 获取 扫描类 、 添加过滤器(Tab)
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);
        // 设置 注解 过滤器
        scanner.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));
        Set<Class<?>> list = new HashSet<>();
        // 获取基础包名
        Set<String> basePackages = getBasePackages(metadata);
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);
            for (BeanDefinition candidateComponent : candidateComponents) {
                try {
                    // 获取有 TableName 注解的 entity
                    Class<?> aClass = ClassUtils.forName(Objects.requireNonNull(candidateComponent.getBeanClassName()),
                            ClassUtils.getDefaultClassLoader());
                    // 获取 字段 注解带有 JsonTypeHandle 的 字段，并获取类型
                    ReflectionUtils.doWithFields(aClass, f -> {
                        if (f.isAnnotationPresent(JsonTypeHandle.class)) {
                            Class<?> type = f.getType();
                            if (BeanUtils.isSimpleProperty(type)) {
                                throw new IllegalArgumentException(
                                        "Annotation JsonTypeHandle field class is not simple property! entity = ["
                                                + aClass.getName() + "], field name = [" + f.getName()
                                                + "]field class = [" + type.getName() + "]");
                            }
                            if (ClassUtils.isAssignable(Collection.class, type)) {
                                throw new IllegalArgumentException(
                                        "Annotation JsonTypeHandle field class is not collection type! entity = ["
                                                + aClass.getName() + "], field name = [" + f.getName()
                                                + "]field class = [" + type.getName() + "]");
                            }
                            list.add(type);
                        }
                    });
                }
                catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(JsonTypeCustomizer.class);
        definition.setScope(BeanDefinition.SCOPE_SINGLETON);
        definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

        AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();

        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addGenericArgumentValue(list);
        beanDefinition.setConstructorArgumentValues(constructorArgumentValues);

        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, "jsonTypeCustomizer", null);
        BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);

    }

    private Set<String> getBasePackages(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(JsonTypeScan.class.getName());

        Set<String> basePackages = new HashSet<>();
        for (String pkg : (String[]) attributes.get("value")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        for (String pkg : (String[]) attributes.get("basePackages")) {
            if (StringUtils.hasText(pkg)) {
                basePackages.add(pkg);
            }
        }
        for (Class<?> clazz : (Class[]) attributes.get("basePackageClasses")) {
            basePackages.add(ClassUtils.getPackageName(clazz));
        }

        if (basePackages.isEmpty()) {
            basePackages.add(ClassUtils.getPackageName(importingClassMetadata.getClassName()));
        }
        return basePackages;
    }

    private ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        JsonTypeCustomizer bean = applicationContext.getBean(JsonTypeCustomizer.class);
//    }


    public static class JsonTypeCustomizer implements ConfigurationCustomizer {

        private Set<Class<?>> list;

        public JsonTypeCustomizer(Set<Class<?>> list) {
            this.list = list;
        }

        @Override
        public void customize(Configuration configuration) {
            if (CollectionUtils.isEmpty(list)) {
                return;
            }
            // noinspection unchecked
            list.forEach(v -> configuration.getTypeHandlerRegistry().register(v, new JsonObjectTypeHandler(v)));
        }
    }
}
