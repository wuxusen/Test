package com.wxs.algorithm.week02;

import java.util.Arrays;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-03-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class minIncrementForUnique945 {



    public int minIncrementForUnique(int[] A) {


        Arrays.sort(A);

        int count = 0,max = -1;

        for (int i = 0; i < A.length; i++) {

            if(A[i]  <= max){
                int ai = max + 1;

                count = count + (ai - A[i]);
                A[i] = ai;
            }

            max = Math.max(max,A[i]);

        }


        return count;
    }


}
