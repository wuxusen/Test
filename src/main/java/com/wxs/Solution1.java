package com.wxs;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-06-28
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Solution1 {


    public static boolean hasCycle(ListNode head) {

        long time = System.currentTimeMillis();
        long endTime = time + 5000;
        ListNode cruu = head;

        while (System.currentTimeMillis() < endTime) {

            if (cruu == null) {
                return false;
            }
            cruu = cruu.next;

        }

        return true;

    }


    public static ListNode swapPairs(ListNode head) {


        return null;

    }


    public static ListNode reverseList(ListNode head) {

        ListNode next = head.next;
        if (next == null) {
            return head;
        }
        ListNode listNode = reverseList(next);
        head.next.next = head;
        head.next = null;
        return listNode;


    }


    public static ListNode reverseList3(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode listNode = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;

    }


    public static ListNode reverseList1(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode listNode = curr.next;

            curr.next = prev;

            prev = curr;

            curr = listNode;

        }

        return prev;


    }

    public static ListNode reverseList4(ListNode head) {

        ListNode prev = null;

        ListNode curr = head;

        while (curr != null) {

            ListNode listNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = listNode;

        }


        return prev;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);

        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(0);
        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(1);
//        listNode4.next = listNode5;


        // ListNode list = reverseList4(listNode);

        boolean palindrome = Solu.isPalindrome(listNode);


        System.out.println(palindrome);


        //    System.out.println(list);
        // hasCycle(listNode);

    }


}




class Solu {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while (fast != null && fast.next != null) {
            //反转前半段链表
            pre = slow;
            slow = slow.next;

            fast = fast.next.next;

            //先移动指针再来反转
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = fast == null ? slow.next : slow;
        while (p1 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;

        }

        return true;
    }
}