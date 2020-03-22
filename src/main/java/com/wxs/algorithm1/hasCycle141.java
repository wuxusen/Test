package com.wxs.algorithm1;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-13
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class hasCycle141 {



    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        hasCycle1(one);


    }




    // 时间复杂度为O(N) 空间 O(1)
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow){

            if (fast == null || fast.next == null) {
                return false;
            }


            slow = slow.next;
            fast = fast.next.next;


        }

        return true;

    }


    public static boolean hasCycle1(ListNode head) {



        ListNode slow = head;

        ListNode fast = head;

        while (fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }

        }

        return false;

    }



}
