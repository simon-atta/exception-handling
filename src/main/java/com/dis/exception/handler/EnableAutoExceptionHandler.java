package com.dis.exception.handler;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(GlobalBusinessExceptionHandler.class)
public @interface EnableAutoExceptionHandler {
}
