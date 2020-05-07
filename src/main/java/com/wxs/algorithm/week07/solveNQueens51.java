package com.wxs.algorithm.week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-27
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


    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {


        char[][] board = new char[n][n];

        for (char[] str : board) {
            Arrays.fill(str,'.');
        }


        backTrack(0,board);

        return res;

    }


    public void backTrack(int row,char[][] board){

        // 结束条件
        if(row == board.length){
            res.add(charArray2String(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(!isValid(board,row,i))continue;
            board[row][i] = 'Q';
            backTrack(row+1,board);
            board[row][i] = '.';
        }



    }

    private boolean isValid(char[][] board, int row, int col) {


        int n = board.length;

        for (int i = 0; i <n; i++) {

            // 每一行只放置一个，不需要检查每行，只需要检查每列和左右对角线
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // 左上角
        for (int i = row - 1,j = col - 1; i >=0  &&  j>=0; i--,j--) {
            if(board[i][j] == 'Q')return false;
        }


        // 右上角

        for (int i = row -1,j = col+1; i >=0 && j < n ; i--,j++) {
            if(board[i][j] == 'Q')return false;
        }


        return true;
    }


    private  List<String> charArray2String(char[][] board){

        List<String> str = new ArrayList<>();

        for (char[] chars : board) {

            str.add(String.valueOf(chars));
        }

        return str;

    }

}
