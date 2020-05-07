package com.wxs.algorithm.week07;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class isValidSudoku36 {


    /*
     * 数独  box_index = (row/3)*3 + col/3
     *
     */


    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Integer> [] rows = new HashMap[9];
        Map<Integer,Integer> [] cols = new HashMap[9];
        Map<Integer,Integer> [] boxes = new HashMap[9];


        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>(9);
            cols[i] = new HashMap<>(9);
            boxes[i] = new HashMap<>(9);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if(board[i][j] != '.'){

                    int n = board[i][j] - '0';

                    int box_index = (i / 3 )* 3 + j/ 3;

                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);


                    if(rows[i].get(n) > 1 || cols[j].get(n) > 1|| boxes[box_index].get(n) > 1){
                        return false;
                    }


                }

            }

        }



        return true;
    }



    public boolean isValidSudoku1(char[][] board) {

        // 9 用来标记有9行， 10 用来表示值 1- 9 ，如果是9的话，就放不下9了
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxes = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.')continue;

                int n = board[i][j] - '0';

                // 找出块下标
                int box_index = (i / 3) * 3 + (j/3);

                rows[i][n]++;
                cols[j][n]++;
                boxes[box_index][n]++;

                if(rows[i][n] > 1 || cols[j][n] > 1|| boxes[box_index][n] > 1){
                    return false;
                }
            }

        }
        return true;
    }


}
