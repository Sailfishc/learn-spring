package com.sailfish.learnspring.aspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author sailfish
 * @create 2020-04-25-10:30 下午
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Idempotent {
    // marker annotation
}