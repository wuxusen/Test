package com.wxs.algorithm.week02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestQueue {

    public static void main(String[] args) {

        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.offer("1");
        stringQueue.offer("2");
        stringQueue.offer("3");
        stringQueue.offer("4");

        System.out.println(stringQueue);


        String peek = stringQueue.peek();
        String poll = stringQueue.poll();


        while (stringQueue.size() > 0){

            String poll1 = stringQueue.poll();
            System.out.println(poll1);
        }

    }
}
