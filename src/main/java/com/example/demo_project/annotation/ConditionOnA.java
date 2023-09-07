package com.example.demo_project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

//matchIfMissing = havingValue都找不到時,加在哪個annotation相當於會跑那裡的預設值 ex: AAA是預設
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented // 記錄用
@ConditionalOnProperty(name = "condition.test", havingValue = "AAA", matchIfMissing = true)
public @interface ConditionOnA {

}
