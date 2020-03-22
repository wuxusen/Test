package com.wxs.algorithm;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class ListUtils {


    public static ListNode get1() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        one.next = two;
        two.next = three;
        return one;
    }


    public static ListNode get2() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(5);
        one.next = two;
        two.next = three;
        return one;
    }

}
