package com.wxs.algorithm.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-01
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class subsets78 {


    public static void main(String[] args) {

        subsets78 subsets78 = new subsets78();
        List<List<Integer>> subsets = subsets78.subsets(new int[]{1, 2, 3});

        System.out.println(subsets);


    }

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();


        if(nums == null || nums.length == 0){
            return res;
        }

        dfs1(res,nums,new ArrayList<Integer>(),0);

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int index) {


        if(nums.length == index){
            res.add(new ArrayList<>(list));
            return;
        }

        dfs(res,nums,list,index + 1);
        list.add(nums[index]);
        dfs(res,nums,list,index + 1);
        list.remove(list.size() - 1);

    }





    private void dfs1(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, int index) {


      res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {

            list.add(nums[i]);
            dfs1(res,nums,list,i+1);
            list.remove(list.size() - 1);
        }
    }



}
