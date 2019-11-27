package com.markdown.api.annotation;

import java.lang.annotation.*;

/**
 * ========================
 * JWT验证忽略注解
 * Created with IntelliJ IDEA.
 * Version: v1.0
 * ========================
 * @author lirui
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
