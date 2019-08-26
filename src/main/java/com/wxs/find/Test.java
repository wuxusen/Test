package com.wxs.find;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-01
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Test {


    public static void main(String[] args) {

        int sqrt = sqrt(3);
        System.out.println(sqrt);
    }



    public static int sqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid < x)
                low = (int) (mid + 1);
            else
                high = (int) (mid - 1);
        }
        return high;
    }

}
