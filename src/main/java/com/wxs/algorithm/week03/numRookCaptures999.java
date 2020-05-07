package com.wxs.algorithm.week03;


/**
 * 类描述  ：
 * <p>
 * 思路：
 * 二维数组两次循环，找到 R 车
 * 根据四个向量来移动位置，如果找到+1 ，如果遇到🐘 返回
 * <p>
 * <p>
 * 创建人  : 吴绪森
 * 创建时间：2020-03-26
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class numRookCaptures999 {


    public int numRookCaptures(char[][] board) {
        // 定义方向数组，可以认为是四个方向向量，用来移动坐标
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j] == 'R') {

                    int res = 0;

                    for (int[] direction : directions) {

                        if (burnout(board, i, j, direction)) {
                            res += 1;
                        }

                    }
                    return res;

                }


            }

        }


        return 0;
    }

    /**
     * burnout 横冲直撞的意思（来自欧路词典）
     *
     * @param board     输入棋盘
     * @param x         当前白象位置的横坐标
     * @param y         当前白象位置的纵坐标
     * @param direction 方向向量
     * @return 消灭一个 p，就返回 true
     */
    private boolean burnout(char[][] board, int x, int y, int[] direction) {
       int i = x;
       int j = y;

       while (inArea(i,j)){


           if(board[i][j] == 'B'){
               break;
           }

           if(board[i][j] == 'p'){
               return true;
           }

           i += direction[0];
           j += direction[1];

       }

       return false;

    }

    /**
     * @param i 当前位置横坐标
     * @param j 当前位置纵坐标
     * @return 是否在棋盘有效范围内
     */
    private boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j>=0 && j <8;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        numRookCaptures999 solution = new numRookCaptures999();
        int res = solution.numRookCaptures(board);
        System.out.println(res);
    }

}
