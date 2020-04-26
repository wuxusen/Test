package com.wxs.algorithm.week04;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-06
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class PairTest {


    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("One",1);


        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();

        Q.add(pair);
        Q.add(pair);
        Q.add(pair);


    }
}
