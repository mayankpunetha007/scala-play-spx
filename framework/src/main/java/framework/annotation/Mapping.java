package framework.annotation;

import framework.data.Method;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Mapping {

    Class<?> request();

    Class<?> response();

    Method method();

    String url();
}
