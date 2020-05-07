package com.wxs.algorithm.week03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-02
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class solveNQueens51 {


    public static void main(String[] args) {
        solveNQueens51 solveNQueens51 = new solveNQueens51();
        List<List<String>> lists = solveNQueens51.solveNQueens(8);

        System.out.println(lists);


    }

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {

        if (n <= 0) {
            return null;
        }
        res = new LinkedList<>();
        char[][] board = new char[n][n];

        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }

        backtrack(board, 0);
        return res;



    }

    private void backtrack(char[][] board, int row) {

        if(row == board.length){
            res.add(charToString(board));
            return;
        }

        int n = board[row].length;

        for (int col = 0; col < n; col++) {

            if(isValid(board,row,col)){
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row+1);
            board[row][col] = '.';

        }


    }

    private boolean isValid(char[][] board, int row, int col) {

        int n = board.length;
        for (int i = 0; i < n; i++) {
           if( board[i][col] == 'Q'){
               return true;
           }
        }


        for (int i = row - 1 , j = col + 1 ; i >= 0 &&j < n; i--,j++){
            if(board[i][j] == 'Q'){
                return true;
            }
        }


        for (int i = row - 1 ,  j = col - 1  ;i >= 0 &&j >=0; i--,j-- ){
            if(board[i][j] == 'Q'){
                return true;
            }

        }


        return false;
    }


    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

}
