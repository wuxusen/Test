package com.wxs.algorithm;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：. 两两交换链表中的节点  给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 创建人  : 吴绪森
 * 创建时间：2020-03-13
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class SwapPairs24 {


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;


        ListNode node = swapPairs2(one);

        System.out.println(node);
    }


    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public static ListNode swapPairs2(ListNode head) {


        if (head == null || head.next == null) {

            return head;
        }

        ListNode node = head.next;

        head.next = swapPairs2(node.next);

        node.next = head;

        return node;
    }


    //两两交换
    public static ListNode swapPairs1(ListNode head) {

        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode temp = pre;

        while (temp.next != null && temp.next.next != null) {

            ListNode first = temp.next;
            ListNode second = temp.next.next;

            temp.next = second;
            first.next = second.next;

            second.next = first;


            temp = first;

        }

        return pre.next;

    }


    public static ListNode swapPairs3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;

        return next;
    }




    public static ListNode swapPairs4(ListNode head) {


        ListNode listNode = new ListNode(0);
        listNode.next = head;

        ListNode curr = listNode;


        while (curr.next != null && curr.next.next != null){

            ListNode first = curr.next;
            ListNode second = curr.next.next;

            curr.next = second;

            first.next = second.next;

            second.next = first;

            curr = first;


        }

        return listNode.next;

    }


}

