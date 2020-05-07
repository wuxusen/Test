package com.wxs.algorithm.week02;

import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class TestStack {


    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();



        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        integerStack.push(222);
        integerStack.push(333);


        Integer peek = integerStack.peek();
        Integer pop = integerStack.pop();
        Integer pop1 = integerStack.pop();
        boolean empty = integerStack.empty();
        //search 返回距离栈顶的位置
        int search = integerStack.search(1);

        System.out.println();


    }
}
