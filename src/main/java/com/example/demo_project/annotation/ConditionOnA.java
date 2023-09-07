package com.example.demo_project.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

//matchIfMissing = havingValue���䤣���,�[�b����annotation�۷��|�]���̪��w�]�� ex: AAA�O�w�]
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented // �O����
@ConditionalOnProperty(name = "condition.test", havingValue = "AAA", matchIfMissing = true)
public @interface ConditionOnA {

}
