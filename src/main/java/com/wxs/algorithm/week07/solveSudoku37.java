package com.wxs.algorithm.week07;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-27
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class solveSudoku37 {


    public void solveSudoku(char[][] board) {

        backtrack(board, 0, 0);

    }

    private boolean backtrack(char[][] board, int row, int col) {


        if (col == 9) {
            return backtrack(board, row + 1, 0);
        }

        if (row == 9) {
            return true;
        }


        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }

        for (char k = '1'; k <= '9'; k++) {
            if (!isValid(board, row, col, k)) {
                continue;
            }

            board[row][col] = k;
            if (backtrack(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }


        return false;

    }

    private boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < 9; i++) {

            if (board[row][i] == k) return false;
            if (board[i][col] == k) return false;
            // 块的下标
            int box_index_row = (row / 3) * 3 + i / 3;
            int box_index_col = (col / 3) * 3 + i % 3;

            if (board[box_index_row][box_index_col] == k) return false;


        }

        return true;
    }


}
