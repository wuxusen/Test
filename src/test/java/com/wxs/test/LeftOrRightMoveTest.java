package com.wxs.test;

import org.junit.Test;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-09
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeftOrRightMoveTest {


    /**
     * 位与( & )
     * <p>
     * 所有的奇数 转成二进制时 最后一位都是1 。
     * <p>
     * 如 5 = 2^0 + 2^2  ,3 = 2^1 + 2^0
     * 除了最后一位，其他左边的位置，都是用2的幂运算相加得到的结果=》 不含最后一位的二进制，都是偶数
     * 所以 最后一位是0 ，为偶数 。 最后一位是1，则为奇数。  与&运算 ，X & 1 = 1 时为奇数，X&1= 0时，则为偶数
     * 通过和1与运算，
     * <p>
     * 1和1 与& ，结果是1 ，1和0与运算 结果是0
     * <p>
     * <p>
     * <p>
     * i >> 1 << 1 != i 通过先右移然后左移，判断这个值是否和原值相等，如果相等，表示是偶数，不相等表示奇数
     * <p>
     * <p>
     * <p>
     * 5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
     * <p>
     * 3转换为二进制：0000 0000 0000 0000 0000 0000 0000 0011
     * <p>
     * -------------------------------------------------------------------------------------
     * <p>
     * 1转换为二进制：0000 0000 0000 0000 0000 0000 0000 0001
     */
    @Test
    public void test1() {
        System.out.println(7 & 1); // 判断奇偶和1与， 相同为1，不同为零，实际上就是用来判断最后一位是否是1或0，如果是0位偶数，1位奇数

    }

    /**
     * 为或(|)
     * 5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
     * <p>
     * 3转换为二进制：0000 0000 0000 0000 0000 0000 0000 0011
     * <p>
     * -------------------------------------------------------------------------------------
     * <p>
     * <p>
     * 7转换为二进制：0000 0000 0000 0000 0000 0000 0000 0111
     */
    @Test
    public void test2() {
        System.out.println(5 | 3);

    }

    /**
     * 位 异或(^)
     * 5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
     * <p>
     * 3转换为二进制：0000 0000 0000 0000 0000 0000 0000 0011
     * <p>
     * -------------------------------------------------------------------------------------
     * <p>
     * <p>
     * 6转换为二进制：0000 0000 0000 0000 0000 0000 0000 0110
     * <p>
     * 两值相反为1，相同为0
     */
    @Test
    public void test3() {
        System.out.println(5 ^ 3);

    }


    /**
     * 当数组中，只有一个元素出现了奇数次，其他的都为偶数次。如何快速找出这个值，用异或快速解决
     */
    @Test
    public void test31() {
        System.out.println(5 ^ 3 ^ 5 ^ 3 ^ 3);

    }


    /**
     * 位非
     * 5转换为二进制：0000 0000 0000 0000 0000 0000 0000 0101
     * <p>
     * -------------------------------------------------------------------------------------
     * <p>
     * -6转换为二进制：1111 1111 1111 1111 1111 1111 1111 1010
     */
    @Test
    public void test5() {
        System.out.println(~5);

    }

    @Test
    public void test6() {

        System.out.println(5 << 2);


        System.out.println(5 >> 2);
        System.out.println(5 >> 10);

        System.out.println("----------------------------------");


        System.out.println(5 >> 3);
        System.out.println(-5 >> 3);

        System.out.println(5 >>> 3);
        System.out.println(-5 >>> 3);


        System.out.println("----------------------------------");

        System.out.println(5 << 2);
        System.out.println(2 << 2);


        System.out.println("-------------右移表示表示是除，左移表示乘---------------------");


    }

    @Test
    public void test7() {
        System.out.println("-------------右移表示表示是除2 ---------------------");

        System.out.println(5 >> 1);
        System.out.println(8 >> 1);
        System.out.println(8 >> 2);
        System.out.println(8 >> 3);

    }


    @Test
    public void test8() {
        System.out.println("-------------右移表示表示是除，左移一位表示乘2-  2^移位数次方--------------------");
        System.out.println(2 << 2);


    }

    @Test
    public void test9() {
        System.out.println("-------------交换值--------------------");
        int a = 1, b = 2;

        a ^= b;
        // 01
        // 10   => 11 => b = 3


        b ^= a;
        // 10
        // 11  => 01 => b = 1

        a ^= b;
        // 11
        // 01   => 10 =>  a = 2


        System.out.println("a  = " + a);
        System.out.println("b = " + b);


    }

    @Test
    public void test10() {
        System.out.println("-------------交换值--------------------");
        int a = 1, b = 2;

        a ^= b; //  a = a^b
        b ^= a; // b = b^(a^b) = b^a^b = a;
        a ^= b; // a = a ^ b = a^b^a


        System.out.println("a  = " + a);
        System.out.println("b = " + b);


    }


    /**
     *
     * 如果 -1 的二进制 =》 1111..11111  =》 取非后 0000 ... 0000  + 1 ,得绝对值
     *
     * 11..10 => 取非 00..01 + 1
     *
     * 111..101 => 取非 000..010
     *
     *
     *
     *
     *
     */

    @Test
    public void test11() {
        System.out.println("-------------求绝对值--------------------");

        int a = -55;

        int i = a >> 31; // 如果是正值，i=0 ,如果为负值 i=-1


        System.out.println(i == 0 ? a : ~a + 1);


    }

    @Test
    public void test12() {

        int x = (9 >> 1) & 1;

        System.out.println(x);

    }


    @Test
    public void test13() {

        int x = 24 & -24;

        System.out.println(x);

        String s1 = Integer.toBinaryString(24);
        String s2 = Integer.toBinaryString(-24);

        System.out.println(s1 + "===" + s2);

    }

    public boolean isPowerOfTwo(int n) {
        return n != 0 && (n & (n - 1)) == 0;
    }
}
