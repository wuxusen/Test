package com.wxs.algorithm;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 * <p>
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class ReverseList206 {


    // 时间复杂度 O(n) ,空间复制度O(n)
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return node;


    }


    // 时间复杂度 O(n) ,空间复制度O(1)
    public ListNode reverseList1(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }


        return pre;
    }


    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next != null) {
            return head;
        }

        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public ListNode reverseList3(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    public ListNode reverseList4(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;

    }


    public ListNode reverseList11(ListNode head) {


        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        return pre;

    }


    public static void main(String[] args) {


        ListNode listNode = ListUtils.get1();

        ListNode listNode1 = reverseList13(listNode);
        System.out.println(listNode1);

    }


    public static ListNode reverseList13(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverseList13(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }


    public static ListNode reverseList14(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {

            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }

        return pre;

    }


}
