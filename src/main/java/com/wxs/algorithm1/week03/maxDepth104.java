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

public class maxDepth104 {


    public int maxDepth(TreeNode root) {

        return depth(root);

    }

    /**
     * 时间复杂度 每个节点都要遍历到 所以是O(n) ,空间复杂度 最差 O(n) 最好 logN
     * @param node
     * @return
     */
    public int depth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));

    }

}
