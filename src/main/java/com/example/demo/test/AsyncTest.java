package com.example.demo.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author: fangyurui
 * @Description:
 * @Date: 2019-06-12
 */
@Component
public class AsyncTest {

    /**
     * 1、无返回值
     * 2、返回值Future<String>，需监听
     * @param num
     */
    @Async
    public void asyncGet (long num) {
        long a = System.currentTimeMillis();
        System.out.println();
        String str = "";
        for (long i = 0 ; i < 100000; i++) {
            str += "a";
            num++;
        }
        long b = System.currentTimeMillis();
        System.out.println("cost " + (b-a) + " ms");
    }

    public static void main(String[] args) {
        long num = 0l;
        System.out.println("a");
        AsyncTest t = new AsyncTest();
//        num = t.asyncGet(num);
        System.out.println("b");
        System.out.println(num);
        System.out.println("c");
    }

}
