package com.wxs.sort;

/**
 * 类描述  ：第K大元素
 * 创建人  : 吴绪森
 * 创建时间：2019-08-01
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class KthBig {


    public static void main(String[] args) {

        int[] a = {1,2,2};


        int kTh = sort(a,2);

        System.out.println("第一大元素是 >>>>"+kTh);

    }


    public static int sort(int[] nums,int k){

        if(k > nums.length){
            return -1;
        }
        if(nums.length == 1 && k == 1){
            return nums[0];
        }


        int randomIndex = parition(nums,0,nums.length - 1);

        while (randomIndex+1 != k ){

            if(randomIndex+ 1 < k){
                randomIndex = parition(nums,randomIndex+1,nums.length - 1);
            }else {
                randomIndex = parition(nums,0,randomIndex - 1);
            }

        }

        return nums[randomIndex];
    }


    public static int parition(int[] nums,int low,int high){

        int highV = nums[high];

        int j = low;

        for (int i = low; i < high; i++) {

            if(nums[i] >= highV){
                if(i == j){
                    j++ ;
                }else {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;

                }

            }


        }
        int tmp = nums[j];
        nums[j] = nums[high];
        nums[high] = tmp;

        return j;
    }


}
