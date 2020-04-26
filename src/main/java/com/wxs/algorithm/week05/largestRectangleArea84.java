package com.wxs.algorithm.week05;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class largestRectangleArea84 {


    public static void main(String[] args) {
        largestRectangleArea84 largestRectangleArea84 = new largestRectangleArea84();

        largestRectangleArea84.largestRectangleArea(new int[]{4,2,0,3,2,4,3,4});

    }



    public int largestRectangleArea(int[] heights) {


        int i = 0, j = heights.length - 1, res = 0;
        while(i <= j){

            int min = Integer.MAX_VALUE;
            for (int k = i; k <= j; k++) {
                min = Math.min(min,heights[k]);
            }

            res = Math.max(res,(j - i + 1) * min);

           if(heights[i] < heights[j]){
               i ++ ;
           }else {
               j--;
           }


        }
        return res;





    }







}
