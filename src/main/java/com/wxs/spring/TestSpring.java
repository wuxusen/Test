package com.wxs.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-08-11
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestSpring {


    public static void main(String[] args) {

        new ReentrantLock();
        ApplicationContext context = new ClassPathXmlApplicationContext("");


        Stack<String> strings = new Stack<>();


        PriorityQueue p = new PriorityQueue();
        Map map = new HashMap<>();
    }
}
