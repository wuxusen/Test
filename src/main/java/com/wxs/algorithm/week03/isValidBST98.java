package com.wxs.algorithm.week03;

import java.util.Stack;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isValidBST98 {


    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);

    }


    /**
     * 时间复杂度 ON 每个节点访问一次, 空间复杂度 ON ，需要比较所有节点
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {

        if (node == null) {
            return true;
        }

        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.left, lower, val)) return false;
        if (!helper(node.right, upper, val)) return false;

        return true;
    }


    /**
     * 二叉树的中序遍历可以 按从小到大的顺序打出，依次判断当前节点大于前一个节点
     * 时间空间都是ON
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        double min = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.val <= min) {
                return false;
            }
            min = root.val;
            root = root.right;
        }

        return true;
    }



    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }




}
