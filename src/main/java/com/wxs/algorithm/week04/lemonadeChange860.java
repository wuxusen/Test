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

public class lemonadeChange860 {


    public static void main(String[] args) {
        lemonadeChange860 lemonadeChange860 = new lemonadeChange860();

        boolean b = lemonadeChange860.lemonadeChange(new int[]{5,5,5,5,20,20,5,5,20,5});
        System.out.println(b);
    }

    public boolean lemonadeChange(int[] bills) {


        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {

            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                if(five < 1){
                    return false;
                }
                five--;
                ten++;
            }else {
                if(ten > 0 && five > 0){
                    ten--;
                    five--;

                }else if(five >=3){
                    five -=3;
                }else {
                    return false;
                }
            }


        }

        return true;

    }
}
