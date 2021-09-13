package com.hyssop.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Wrong100 {
    private static final Logger log = LoggerFactory.getLogger(Wrong100.class);
    public void test(){

        int[] arr = {1, 2, 3};
        //这个跟之前数据共用一个数组
        List list = Arrays.asList(arr);
      //  System.out.println("list:{} size:{} class:{}" + list+ list.size()+ list.get(0).getClass());
        log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());
    String[] s= new String[]{"1","2","3","4"};
    List list1 = Arrays.asList(s);
        list1.add(5);
    s[2]="5";
        System.out.println(list1.get(2));
    }

    public static void main(String[] args) {
        Wrong100 wrong100 = new Wrong100();
        wrong100.test();
    }
}
