package com.wxs.algorithm1.week02;

import java.util.Stack;

public class MinStack155 {


    public static void main(String[] args) {

        MinStack155 minStack = new MinStack155();

        minStack.push(4);
        minStack.push(8);
        minStack.push(23);
        minStack.push(5);
        minStack.push(2);
        minStack.push(6);
        minStack.push(1);
        minStack.push(11);







    }


    /**
     * 辅助栈 出栈入栈的时间复杂度为1,空间复杂度为n
     */


    // 数据栈
    private Stack<Integer> data;
    // 辅助栈
    private Stack<Integer> helper;

    public MinStack155() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    //数据栈和辅助栈在任何时候都同步,只不多是值不一样，数据栈存全量值，辅助栈存比第一个入栈 小于等于的数
    public void push(int x) {
       // 数据量相等，但值不一样
        data.add(x);
        if(helper.isEmpty() || helper.peek() >= x){
            helper.add(x);
        }else {
            helper.add(helper.peek());
        }
    }
    // 数据量一样，弹出需同步
    public void pop() {
       if(!data.empty()){
           data.pop();
           helper.pop();
       }
    }
    // 数据栈栈顶
    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
    // 辅助栈栈顶
    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }


    /**
     * -------------------------------------------------------------------------------------------
     *
     */


    // 数据栈和辅助栈不同步
    // 思路： push的时候，只有辅助栈栈顶 小于等于的值，放入辅助栈(第一次入辅助栈，保证辅助栈不为空)

    public void push1(int x) {
        data.add(x);
        if(helper.empty() || helper.peek() >= x){
            helper.add(x);
        }

    }

    // 因为数据栈和辅助栈数据不同步，所以在弹出的时候，必须判断是否相等，如果相等辅助栈也要弹出
    public void pop1() {

        if(data.empty()){
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
        int pop = data.pop();
        if(pop == helper.peek()){
            helper.pop();
        }

    }



}