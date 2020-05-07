package com.wxs.algorithm1.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class preorderTraversal144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        preorder(list, root);

        return list;

    }


    public void preorder(List<Integer> list, TreeNode node) {

        if (node == null) {
            return;
        }

        list.add(node.val);
        preorder(list, node.left);
        preorder(list, node.right);


    }

    // 前序遍历，首先要保证弹出的第一个元素是根节点，
    // 为了先让左子节点先弹出，应该是后进栈。 让右子节点先入栈

    public List<Integer> preorderTraversal1(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode curr = root;

        while (!stack.empty()) {


            TreeNode pop = stack.pop();
            list.add(pop.val);

            if(curr.right != null){
                stack.push(curr.right);
            }
            if (curr.left != null){
                stack.push(curr.left);
            }

        }

        return list;

    }


    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.empty()) {
            TreeNode pop = stack1.pop();
            stack2.push(pop);

            if(pop.left != null){
                stack1.push(pop.left);
            }

            if(pop.right != null){
                stack1.push(pop.right);
            }
        }


        while (!stack2.empty()){
            list.add(stack2.pop().val);
        }
        return list;

    }



    public List<Integer> preorderTraversal3(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> stack1 = new LinkedList<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            TreeNode node = stack1.pollLast();
            stack1.addFirst(node);



        }


        while (!stack1.isEmpty()){
            list.add(stack1.pop().val);
        }
        return list;

    }


}
