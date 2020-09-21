package com.wxs.AlgorithmTest;

import com.wxs.algorithm.week03.TreeNode;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class sortedArrayToBST108 {


    /**
     *  dfs  找到中点后，前序遍历 ，每次前序遍历需要确定left right
     *  其实每次遍历都是给中点赋值
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {

        return dfs(0,nums.length -1,nums);

    }


    private TreeNode dfs(int left, int right, int[] nums) {
        if(left > right) return null;

        // 中点位置选择有两种，奇数是中点，偶数为左中点
        int mid = (left + right) /2;
        // if((left + right) %2 == 1 ) mid+=1



        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(left,mid - 1,nums);
        node.right = dfs(mid+1,right,nums);

        return node;
    }
}
