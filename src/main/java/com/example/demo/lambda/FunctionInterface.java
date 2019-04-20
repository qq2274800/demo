package com.example.demo.lambda;

/**
 * 函数接口：只有一个方法的接口。作为Lambda表达式的类型
 * Created by Kevin on 2018/2/17.
 */
public interface FunctionInterface<T> {
    String test(T params);
}
