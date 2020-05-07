package com.wxs.algorithm1.week03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color){
            this.node = node;
            this.color = color;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
            
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root,"white"));
        
        while(!stack.empty()){
            ColorNode cn = stack.pop();
            
            if(cn.color.equals("white")){
                  stack.push(new ColorNode(cn.node,"gray"));
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,"white"));
              
                if(cn.node.left != null)stack.push(new ColorNode(cn.node.left,"white"));
            }else{
                res.add(cn.node.val);
            }
        }
        
        return res;
    }
}