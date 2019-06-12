package com.example.demo;

import com.example.demo.test.AsyncTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTests {

    @Autowired
    private AsyncTest asyncTest;

    @Test
    public void test() {

        long num = 0l;
        System.out.println("a");
        asyncTest.asyncGet(num);
        System.out.println("b");
        System.out.println(num);
        System.out.println("c");

    }

}
