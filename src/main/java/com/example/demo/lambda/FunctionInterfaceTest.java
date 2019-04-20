package com.example.demo.lambda;

import org.junit.Test;

/**
 * 函数接口测试
 * Created by Kevin on 2018/2/17.
 */
public class FunctionInterfaceTest {

    @Test
    public void testLambda() {
//        func(new FunctionInterface() {
//            @Override
//            public String test(Object params) {
//                return null;
//            }
//        });
        //使用Lambda表达式代替上面的匿名内部类
        func((Integer i) -> {
            return String.valueOf(i);
        });
    }

    private void func(FunctionInterface<Integer> functionInterface) {
        Integer i = 1;
        System.out.println(functionInterface.test(i));
    }
}