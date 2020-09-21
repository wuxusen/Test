package com.wxs.AlgorithmTest;

import com.wxs.algorithm.week03.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class maxDepth55 {

    public static void main(String[] args) {
        if (true) {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 1024);
        }
       // int replacer = 1;
        System.gc();
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }

            }

        }

        return res;
    }


}
