package com.gpcoder.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Annotation này có thể sử dụng tại thời điểm chạy (Runtime) của chương trình.
@Retention(RetentionPolicy.RUNTIME)
// Có thể dùng cho class,interface, method, field, parameter.
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
public @interface MyAnnotation {

	String name();

	String value() default "Defaul value";
}
