package com.wxs.backtracking;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019/9/25
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class Order2 {


    /**
     * @param iterm 物品价格
     * @param n     物品数量
     * @param w     满减条件
     */
    public static void double11advance(int[] iterm, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];
        states[0][0] = true;
        if (iterm[0] <= 3 * w) {
            states[0][iterm[0]] = true;
        }

        for (int i = 1; i < states.length; i++) {
            for (int j = 0; j <= 3 * w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = true;
                }
            }
            for (int j = 0; j <= 3 * w - iterm[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + iterm[i]] = true;
                }
            }


        }
        int j;
        for (j = w; j < 3 * w + 1; j++) {
            if (states[n - 1][j]) break;
        }

        if (j == 3 * w + 1) {
            return;
        }


        for (int i = n - 1; i >= 1; i--) {
            if (j - iterm[i] >= 0 && states[i -1][j-iterm[i]]){
                System.out.print(iterm[i]+" ");
                j = j-iterm[i];
            }


        }

        if (j !=0) System.out.println(iterm[0]);







    }


}
