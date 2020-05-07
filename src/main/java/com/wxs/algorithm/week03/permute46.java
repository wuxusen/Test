package com.wxs.algorithm.week03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 类描述  ： 全排列
 * 创建人  : 吴绪森
 * 创建时间：2020-03-29
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class permute46 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute46 solution = new permute46();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);

    }

    public List<List<Integer>> permute(int[] nums) {

        // 用来保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(nums == null || nums.length < 1){
            return res;
        }

        int length = nums.length;
        boolean[] visited = new boolean[nums.length];

        backtrack(nums,length,0,path,visited,res);


        return res;

    }

    private void backtrack(int[] nums, int length, int depth, List<Integer> path, boolean[] visited, List<List<Integer>> res) {

        if(depth == length){
            res.add(path);
            return;
        }


        for (int i = 0; i < length; i++) {

            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backtrack(nums,length,depth+1,path,visited,res);
                visited[i] = false;
                path.remove(path.size() - 1);

            }


        }

    }


    List<List<Integer>> res = new ArrayList<>();


    public List<List<Integer>> permute1(int[] nums) {


        if(nums == null || nums.length == 0){
            return res;
        }

       // backtrack1(nums,new ArrayList<>());

        ArrayList<Integer> path = new ArrayList<>();
        for (int num : nums)
            path.add(num);


        backtrack2(nums.length,0,path);

        return res;

    }

    private void backtrack1(int[] nums, List<Integer> path) {

        if(path.size() == nums.length){
           res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(path.contains(nums[i]))
                continue;

            path.add(nums[i]);
            backtrack1(nums,path);
            path.remove(path.size()-1);
        }


    }



    private void backtrack2(int len,int index, List<Integer> path) {

        if(len == index){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {

            Collections.swap(path,i,index);
            backtrack2(len,index + 1 ,path);
            Collections.swap(path,i,index);
        }

    }

    private void swap(int[] nums, int i, int index) {

        int tmp = nums[i];

        nums[i] = nums[index];

        nums[index] = tmp;


    }


}
