package com.example.demo.thread;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @desc CompletableFuture类,监听多线程的完成
 */
public class CompletableFuture {

    public static void main(String[] args) {
        CompletableFuture cf = new CompletableFuture();
        try {
            cf.contextLoads();
//            cf.thenApply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CompletableFuture主体方法
     */
    public void contextLoads() {
        long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        java.util.concurrent.CompletableFuture[] cfs = taskList.stream()
                .map(integer -> java.util.concurrent.CompletableFuture.supplyAsync(() -> calc(integer), executorService)
                        .thenApply(h->Integer.toString(h))
                        .whenComplete((s, e) -> {
                            System.out.println("任务"+s+"完成!result="+s+"，异常 e="+e+","+new Date());
                            list.add(s);
                        })
                ).toArray(java.util.concurrent.CompletableFuture[]::new);
        // 封装后无返回值，必须自己whenComplete()获取
        java.util.concurrent.CompletableFuture.allOf(cfs).join();
        System.out.println("list="+list+",耗时="+(System.currentTimeMillis()-start));

    }

    public int calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName()
                    + "任务i=" + i + ",完成！+" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 测试thenApply方法，用于第二个线程对于第一个线程的依赖
     * @throws Exception
     */
    public void thenApply() throws Exception {
        java.util.concurrent.CompletableFuture<Long> future = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            long result = new Random().nextInt(100);
            System.out.println("result1="+result);
            return result;
        }).thenApply((t) ->  {
            long result = t*5;
            System.out.println("result2="+result);
            return result;
        });

        long result = future.get();
        System.out.println(result);
    }



}
