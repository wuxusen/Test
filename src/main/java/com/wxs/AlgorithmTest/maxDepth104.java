package com.wxs.AlgorithmTest;

import com.wxs.algorithm.week03.TreeNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-07-15
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class maxDepth104 {


    public int maxDepth(TreeNode root) {

        return depth(root);

    }

    private int depth(TreeNode node) {

        if(node == null){
            return 0;
        }
        return 1 + Math.max(depth(node.left),depth(node.right));
    }

}
