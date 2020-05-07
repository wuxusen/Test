package com.wxs.algorithm1.week03;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class middleNode876 {


    /**
     * 解题思路：
     * 1，可以创建一个比较大的数组，用来放每个listNode ,用指针记录 数组被填满的位置，遍历完成后，返回 数组指针/2的位置
     * 2，遍历两边node，第一遍记录最大位置，第二遍到最大位置/2
     * 3,快慢指针，慢 = 1 ，快 = 2，当快指针结束时，慢指针到了中间位置
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        if(head == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;


    }


}
