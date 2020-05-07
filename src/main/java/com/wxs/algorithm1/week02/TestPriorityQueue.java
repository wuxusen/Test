package com.wxs.algorithm1.week02;

import com.wxs.Person;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 *
 *
 * 插入操作1
 * 取出操作 logN
 *
 */

public class TestPriorityQueue {


    public static void main(String[] args) {
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                return o1.getAge() > o2.getAge() ? 1 : -1;
            }
        };


        PriorityQueue<Person> priorityQueue = new PriorityQueue<Person>(comparator);

        priorityQueue.add(Person.builder().age(5).name("1").build());
        priorityQueue.add(Person.builder().age(18).name("2").build());
        priorityQueue.add(Person.builder().age(88).name("3").build());
        priorityQueue.add(Person.builder().age(30).name("4").build());
        priorityQueue.add(Person.builder().age(50).name("5").build());



        while (priorityQueue.size() > 0){

        }


    }
}
