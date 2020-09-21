package com.wxs.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wxs.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void mapT1111(){







    }



    @Test
    public void mapToString(){
        Map<String,String> map = Maps.newHashMap();
        map.put("1","yi");
        map.put("2","er");


        System.out.println(map.toString());


    }




    @Test
    public void aaa(){


        double x = 0.6181189802430973;
        double y = -0.3589041095890411;



        double pow = Math.pow(x, y);

        System.out.println(pow);

        //-0.6181189802430973
        //-0.3589041095890411
      /*  System.out.printf("e 的值为 %.4f%n", Math.E);
        System.out.printf("pow(%.3f, %.3f) 为 %.3f%n", x, y, Math.pow(x, y));*/
    }


    @Test
    public void test9() {


        Person person = new Person();
        person.setShow(1493740800000L);

        Person person1 = new Person();
        person1.setShow(1505836800000L);


        Person person2 = new Person();
        person2.setShow(1525836800000L);


        ArrayList<Person> people = Lists.newArrayList(person, person1, person2);



        people.sort((a, b) -> {
            Long value = a.getShow() - b.getShow();
            return b.getShow().compareTo(a.getShow());
        });


        System.out.println(people);

    }

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

/*

    @Test
    public void test12() {
        List<Person> byApiNames = Lists.newArrayList();
        Map<String, String> apiNameLabel = byApiNames.stream().collect(Collectors.toMap(k -> k.getAge(), k -> k.getName(), (k1, k2) -> k2));


        System.out.println(apiNameLabel);
    }
*/


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


    @Test
    public void test81() {


        String s = null;

        int i = Integer.parseInt(s);

        System.out.println(i);

    }

}
