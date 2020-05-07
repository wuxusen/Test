package com.wxs.algorithm.week07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述  ：全排列
 * 创建人  : 吴绪森
 * 创建时间：2020-04-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class permute46 {


    public static void main(String[] args) {


        permute46 permute46 = new permute46();

        List<List<Integer>> permute = permute46.permute(new int[]{1, 2, 3});

        System.out.println(permute);
    }

    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {


        if(nums == null || nums.length == 0){
            return res;
        }

        backTrack(nums,new LinkedList<>());

        return res;

    }

    private void backTrack(int[] nums, LinkedList<Integer> path) {


        if(nums.length == path.size()){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(path.contains(nums[i]))continue;
            path.add(nums[i]);
            backTrack(nums,path);
            path.removeLast();
        }


    }


}
