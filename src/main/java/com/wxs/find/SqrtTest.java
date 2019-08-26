package com.wxs.find;

import java.util.Date;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-12
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class SqrtTest {
    public static void main(String[] args) {
        System.out.println("start: " + new Date().getTime());

        double num = 0.16;
        double temp = 0;
        if (num > 1) {
            temp = execute(0, num, num);
        } else { // 大于0小于1的值
            temp = execute(0, 1, num);
        }
        System.out.println("end: " + new Date().getTime());
        System.out.println(temp);
    }

    /**
     * desc: 二分法计算开平方根
     *
     * @param min 最小区间值
     * @param max 最大区间值
     * @param num 被开平方数
     * @return
     */
    public static double execute(double min, double max, double num) {
        double temp = (min + max) / 2.0; // 求得中间值
        if (max - min <= 0.000001) { // 精确的位数
            return temp;
        } else if (temp * temp > num) { // 判断区间值
            return execute(min, temp, num); // 递归调用
        } else if (temp * temp < num) {
            return execute(temp, max, num);
        } else {
            return temp;
        }
    }
}
