package com.wxs;

import com.wxs.queue.ListNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-07-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class StackBaseLinkList {

    private ListNode top = null;



    public void push(int value){

        if(top == null){
            top = new ListNode(value);
        }else {
            ListNode listNode = new ListNode(value);
            listNode.next = top;
            top = listNode;
        }
    }


    public int pop(){
        if(top == null){
            return -1;
        }

        ListNode pop = top;
        top = top.next;
        return pop.val;
    }



}
