package com.wxs.algorithm.week02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestDeque {

    public static void main(String[] args) {

        test3();

    }


    public static void test2() {


        Deque<String> deque = new LinkedList<>();

        deque.offer("1");
        deque.offer("2");
        deque.offer("3");
        System.out.println(deque);

        // 3
        String peek = deque.peekLast();
        System.out.println(peek);
        System.out.println(deque);

        while (deque.size() > 0) {

            System.out.println(deque.pollLast());
        }


        System.out.println(deque);
    }


    public static void test1() {


        Deque<String> deque = new LinkedList<>();

        deque.push("1");
        deque.push("2");
        deque.push("3");
        deque.push("4");
        deque.push("5");
        deque.push("6");
        deque.push("7");


        String peek = deque.peek();
        String s1 = deque.peekFirst();
        String s2 = deque.peekLast();


        String poll = deque.poll();
        String s3 = deque.pollFirst();
        String s4 = deque.pollLast();
        System.out.println(poll + "=====>3 ");
        String s = deque.pollLast();

        System.out.println(s + "======>1");

//        while (deque.size() > 0){
//
//            System.out.println(deque.poll());
//        }


        System.out.println(deque);
    }


    public static void test3() {


        Deque<String> deque = new ArrayDeque<>();

        deque.offer("0");
        deque.offer("1");


        String s = deque.peekLast();
        System.out.println(s);


    }

}
