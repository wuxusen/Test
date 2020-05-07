package com.wxs.algorithm.week08;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-04
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class reverseBits190 {

    public static void main(String[] args) {
        reverseBits190 reverseBits190 = new reverseBits190();

        //reverseBits190.reverseBits(   964176192);


        System.out.println(0 << 1);
    }

    /**
     *  用ans 来保存移位的值，比如 第一位 ，ans需要左移一位，加上n&1,与运算得到的最后一位，
     *  n 右移一位，保持最后一位是需要下次循环获得的值
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0;i < 32;i++){
            ans = (ans << 1) + (n & 1);
            n >>= 1;
        }
        return ans>>> 0;
    }
}
