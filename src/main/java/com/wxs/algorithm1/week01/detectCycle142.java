package com.wxs.algorithm1.week01;

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

public class detectCycle142 {




    public static ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (true ) {

            if(fast == null || fast.next == null){
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }

        }

        fast = head;
        while (fast != slow){
           fast = fast.next;
           slow = slow.next;
        }


        return fast;
    }


    public static ListNode detectCycle1(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }

        }
        return null;
    }



}
