package com.wxs.algorithm.week04;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class jump45 {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        jump45 jump45 = new jump45();
        jump45.jump2(nums);

    }


    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public int jump1(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    public int jump2(int[] nums) {

        int position = nums.length - 1;
        int steps = 0;

        while (position != 0) {

            for (int i = 0; i < position; i++) {

                if (nums[i] >= position - i) {

                    position = i;
                    steps++;
                }


            }
        }

        return steps;


    }


    public int jump3(int[] nums) {


        int position = nums.length - 1;
        int steps = 0;
        while (position != 0) {

            for (int i = 0; i < position; i++) {


                if (nums[i] >= position - i) {

                    position = i;
                    steps++;

                }


            }


        }
        return steps;


    }


    public int jump4(int[] nums) {


        int start = 0;
        int steps = 0;

        int end = 1;


        while (end < nums.length) {

            int MaxStep = 0;
            for (int i = start; i < end; i++) {
                MaxStep = Math.max(MaxStep, nums[i]);
            }

            start = end;
            end = MaxStep+1;
            steps++;


        }
        return steps;


    }




    public int jump5(int[] nums) {


        int start = 0;
        int steps = 0;

        int end = 1;


        while (end < nums.length) {

            int MaxStep = 0;
            for (int i = start; i < end; i++) {
                MaxStep = Math.max(MaxStep, nums[i]);
            }

            start = end;
            end = MaxStep+1;
            steps++;


        }
        return steps;


    }

    public int jump6(int[] nums) {


        int maxStep = 0;
        int steps = 0;
        int end = 0;


        for (int i = 0; i < nums.length; i++) {


            maxStep = Math.max(maxStep,nums[i] + 1);

            if(i == end){

                end = maxStep;
                steps ++ ;
            }




        }


        return steps;

    }





    public int jump7(int[] nums) {

        int start = 0;

        int end = 1;

        int step = 0;

        while (end <nums.length){

            int maxStep = 0;

            for (int i = start; i < end; i++) {
                maxStep = Math.max(maxStep,nums[i]);
            }

            start = end;

            end = maxStep + 1;

            start ++ ;


        }

        return step;




    }









}
