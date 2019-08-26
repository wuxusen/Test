package com.wxs.queue;

import com.wxs.MergerList;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MyLIst {


    public static void main(String[] args) {


        ListNode one1 = MergerList.getOne1();

        ListNode list =  remove(one1,2);

    }


    public static ListNode remove(ListNode head,int n){


        ListNode start = new ListNode(0);

        start.next = head;

        ListNode first = start;

        ListNode second = start;

        for (int i = 1 ;i < n + 1 ; i ++){
            first = first.next;
        }

        while (first.next != null){

            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return start.next;


    }




}
