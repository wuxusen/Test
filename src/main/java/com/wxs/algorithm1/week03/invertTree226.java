package com.wxs.algorithm1.week03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class invertTree226 {


    public static void main(String[] args) {
        invertTree226 invertTree226 = new invertTree226();


    }

    public TreeNode invertTree(TreeNode root) {
        root = invert(root);
        return root;
    }

    /**
     * 每个节点访问一次，时间浮复杂度O(N) ,空间复杂度 ，栈内需要存放O(h) -> O(n)
     * @param root
     * @return
     */
    private TreeNode invert(TreeNode root) {

        if(root == null){
            return null;
        }

        TreeNode left = invert(root.left);
        TreeNode right = invert(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     *
     * @param root
     * @return
     */
    private TreeNode invert1(TreeNode root) {

        if(root == null){
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            TreeNode curr = queue.poll();

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);

        }
        return root;
    }



}
