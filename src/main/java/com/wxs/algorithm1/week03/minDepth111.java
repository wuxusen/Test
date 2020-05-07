package com.wxs.algorithm1.week03;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class minDepth111 {


    public int minDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if(root == null)return 0;


        if(root.left == null && root.right == null)return  1;

        int right = depth(root.right);
        int left = depth(root.left);

        if(root.right == null || root.left == null){
            return right + left + 1;
        }

        return Math.min(right,left) + 1;
    }

}
