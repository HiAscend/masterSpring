package com.smart.chapter11;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TopicTransactional
 *
 * @author ascend
 * @date 2017/11/16 11:08.
 */
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Transactional(value = "topicTransactionManager")
public @interface TopicTransactional {
}
