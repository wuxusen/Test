package com.wxs;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class MergerList {


    public static void main(String[] args) {

        ListNode l1 = getOne();
        ListNode l2 = getOne1();

      //  ListNode listNode = mergerList1(l1, l2);
      //  System.out.println(listNode);

        ListNode listNode = deleteN1(l1, 1);

        System.out.println(listNode);


    }


    public static ListNode mergerList(ListNode l1, ListNode l2){

        if(l1 == null) {
            return l2;
        }else if(l2 == null){
            return l1;
        }

        if(l1.val <= l2.val){
            l1.next = mergerList(l1.next,l2);
            return l1;
        }else {
            l2.next = mergerList(l1,l2.next);
            return l2;

        }

    }

    public static ListNode mergerList1(ListNode l1, ListNode l2){

        ListNode head = new ListNode(-1);

        ListNode prev = head;

        while (l1 != null && l2 != null){

            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = l1 == null ? l2:l1;

        return head.next;
    }










    public static ListNode getOne(){
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
//        ListNode listNode3 = new ListNode(6);
//        listNode2.next = listNode3;
//        ListNode listNode4 = new ListNode(7);
//        listNode3.next = listNode4;
//        ListNode listNode5 = new ListNode(9);
//        listNode4.next = listNode5;
//        ListNode listNode6 = new ListNode(11);
//        listNode5.next = listNode6;
        return listNode;

    }
    public static ListNode getOne1(){
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(6);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(10);
        listNode4.next = listNode5;
        return listNode;

    }



    public static ListNode deleteN(ListNode head,int n){


        ListNode start = new ListNode(0);
        start.next = head;

        ListNode first = head;

        int lenth = 0;

        while (first != null){

            first = first.next;
            lenth ++ ;
        }

        lenth -=n;

        first = start;

        while (lenth > 0){

            first = first.next;
            lenth -- ;

        }

        first.next = first.next.next;

        return start.next;

    }


    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */

    public static ListNode deleteN1(ListNode head,int n){

        ListNode start = new ListNode(0);

        start.next = head;

        ListNode first = start;

        ListNode second = start;

        for (int i = 1 ;i <= n + 1 ; i ++){
            first = first.next;
        }

        while (first!= null){

            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return start.next;
    }


    public static ListNode mid(ListNode head){


        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

}
