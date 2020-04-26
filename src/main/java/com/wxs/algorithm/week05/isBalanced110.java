package com.wxs.algorithm.week05;

import com.wxs.algorithm.week03.TreeNode;

/**
 * 类描述  ：
 *
 * 判断是否为平衡二叉树
 * 创建人  : 吴绪森
 * 创建时间：2020-04-10
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isBalanced110 {



    // 平衡二叉树   ，左右深度不能超过1
    public boolean isBalanced(TreeNode root) {
        // 终止条件
        if(root ==null) return true;
        if(Math.abs(testDepth(root.left) - testDepth(root.right)) > 1)return false;
        if(!isBalanced(root.left) || !isBalanced(root.right))return false;
        return true;
    }

    // 平衡二叉树   ，左右深度不能超过1
    public boolean isBalanced1(TreeNode root) {
        // 终止条件
        if(root ==null) return true;
        return Math.abs(testDepth(root.left) - testDepth(root.right)) < 2 && isBalanced(root.left) &&isBalanced(root.right);
    }

    private int testDepth(TreeNode root) {
        return root == null ? 0 : Math.max(testDepth(root.right),testDepth(root.left)) + 1;

    }


}
