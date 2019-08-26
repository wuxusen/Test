package com.wxs.string;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-23
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class BMTest {


    public static void main(String[] args) {


        char[] a = {'h', 'a', 'c', 'a', 'a', 'a', 't', 'b', 'c', 'f', 'd', 'f', 'd', 'a', 'd'};

        char[] b = {'b', 'c', 'f', 'd'};

        BMTest bmTest = new BMTest();
        int bm = bmTest.bm(a, a.length, b, b.length);

        System.out.println("bm >>>>>>" + bm);


    }


    private static final int SIZE = 256; // 全局变量或成员变量

    //变量b是模式串，m是模式串的长度，bc表示刚刚讲的散列表。
    private void generateBC(char[] b, int m, int[] bc) {

        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // 计算b[i]的ASCII值
            bc[ascii] = i;
        }
    }

    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表
        int i = 0; // i表示主串与模式串对齐的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i + j] != b[j]) { // 坏字符对应模式串中的下标是j
                    break;
                }
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            i = i + (j - bc[(int) a[i + j]]);
        }
        return -1;
    }

}
