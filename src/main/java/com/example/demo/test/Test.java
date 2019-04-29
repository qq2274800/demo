package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        // 测试
        List<String> list = new ArrayList<>();
        list.add("chengdu");
        list.add("chongqing");
        list.add("beijing");
        filter(list);
    }

    public static void find(List<String> list){
        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(str -> {
            String s = str.substring(1);
            return s.substring(2, 3);
        }));
    }

    public static void filter(List<String> list){
        List<String> nList = list.stream().filter(str -> !str.equals("chengdu")).collect(Collectors.toList());
        System.out.println(nList);
    }

}
