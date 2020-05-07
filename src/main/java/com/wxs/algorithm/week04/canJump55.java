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

public class canJump55 {


    public static void main(String[] args) {
        canJump55 canJump55 = new canJump55();


        int[] a = {2,3,1,1,4};
        boolean b = canJump55.canJump(a);

        System.out.println(b);
    }

    public boolean canJump(int[] nums) {

        if(nums == null){
            return false;
        }

        int maxIndex = nums.length -1 ;

        for (int i = nums.length -1  ; i >= 0; i--) {


            if(nums[i]+i >= maxIndex){

                maxIndex = i;
            }
        }


        return maxIndex == 0;

    }





    public int canJump1(int[] nums) {

        if(nums == null){
            return -1;
        }


        int position = nums.length - 1;
        int step = 0;

        while (position != 0){

            for (int i = 0; i < position; i++) {
               if(nums[i] >= position - i){

                   position = i;

                   step ++ ;

               }

            }


        }


        return step;

    }







}
