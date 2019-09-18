package com.wxs;

import com.wxs.queue.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LIstTest {


    /**
     * 链表翻转
     * @param head
     * @return
     */
    public static ListNode reserverList(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode listNode = reserverList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static ListNode reserverList1(ListNode head){

       ListNode prev = null;
       ListNode curr = head;
       while (curr != null){
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
       }
       return prev;
    }




    public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next, pre = null, prepre = null;
        while(fast != null && fast.next != null) {
            //反转 前半段链表
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            //先移动指针再来反转
            pre.next = prepre;
            prepre = pre;
        }
        ListNode p2 = slow.next;
        slow.next = pre;
        ListNode p1 = fast == null? slow.next : slow;

        while(p1 != null) {
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode listNode6 = new ListNode(6);
        listNode5.next = listNode6;
        ListNode listNode1 = reserverList(listNode);
        System.out.println(listNode1);




      //  boolean palindrome = isPalindrome(listNode);

       // System.out.println(palindrome);

      //  ListNode listNode1 = reserverList1(listNode);
     //   System.out.println(listNode1);

       // ListNode node = mergeTwoLists1(MergerList.getOne1(), MergerList.getOne());
       // System.out.println(node);

        // System.out.println("是否有环："+ circle);


    }


    /**
     * 检测链表是否有环
     * @param listNode
     * @return
     */
    public static boolean findCircle(ListNode listNode){

        Set<ListNode> nodeSet = new HashSet<>();
        while (listNode != null){

            boolean contains = nodeSet.contains(listNode);
            if(contains == true){
                return true;
            }
            nodeSet.add(listNode);
            listNode = listNode.next;
        }
        return false;
    }


    /**
     * 检测链表是否有环 快慢指针
     * @param listNode
     * @return
     */
    public static boolean findCircle1(ListNode head){


        if(head == null || head.next == null)return false;
        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1,l2.next);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1.next,l2);
            return l2;
        }

    }

    public static ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){

                prev = prev.next;
                l1 = l1.next;
            }else {

                prev = prev.next;
                l2 = l2.next;
            }
        }
        prev.next = l1 == null ? l2:l1;
        return head.next;
    }






}
