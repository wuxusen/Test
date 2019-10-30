package com.wxs.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxs.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-10-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

@Slf4j
public class Test3 {


    @Test
    public void test8() {


        List<Integer> list = Lists.newArrayList();


        for (int i = 0; i < 100000; i++) {

            list.add(i);
        }


        list.stream().forEach(e -> {
            log.info(e.toString());
        });





    }


    @Test
    public void test122() {


        Map<String, String> map = Maps.newHashMap();

        String s = map.get("111");

        System.out.println(s);

    }


    @Test
    public void test12() {
        List<Person> byApiNames = Lists.newArrayList();
        Map<String, String> apiNameLabel = byApiNames.stream().collect(Collectors.toMap(k -> k.getAge(), k -> k.getName(), (k1, k2) -> k2));


        System.out.println(apiNameLabel);
    }


    @Test
    public void test1() throws InterruptedException {
        Thread T1 = new Thread(() -> {
            log.info("-------------111111");
            System.out.println("--11");

        });

        T1.start();
        T1.join();

        Thread T2 = new Thread(() -> {
            log.info("-------------222222");
            System.out.println("--22");

        });
        T2.start();
        T2.join();
    }


    @Test
    public void lockTest() {


        Person person1 = new Person();
        Person person2 = new Person();


        new Thread(() -> {
            synchronized (person1) {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (person2) {

                }


            }


        }).start();


        new Thread(() -> {

            synchronized (person2) {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (person1) {


                }


            }


        }).start();


    }


}
