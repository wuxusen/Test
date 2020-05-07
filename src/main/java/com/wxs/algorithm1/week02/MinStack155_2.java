package com.wxs.algorithm1.week02;

public class MinStack155_2 {


    public static void main(String[] args) {

        MinStack155_2 minStack = new MinStack155_2();

        minStack.push(4);
        minStack.push(8);
        minStack.push(23);
        minStack.push(5);
        minStack.push(2);
        minStack.push(6);
        minStack.push(1);
        minStack.push(11);







    }

    private Node head;

    public void push(int x) {

      if(head == null){
          head = new Node(x,x);
      }else {
          head = new Node(x,Math.min(x,head.min),head);
      }

    }

    public void pop() {
       head = head.next;
    }

    public int top() {
        if(head != null){
            return head.val;
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if(head != null){
            return head.min;
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }






    private class Node{

        private int val;
        private int min;

        Node next;

        public Node(int val,int min){
            this.val = val;
            this.min = min;
        }

        public Node(int val,int min,Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }


    }


}