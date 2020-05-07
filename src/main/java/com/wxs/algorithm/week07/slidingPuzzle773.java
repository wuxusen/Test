package com.wxs.algorithm.week07;

import java.util.*;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-03
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class slidingPuzzle773 {


    public static void main(String[] args) {
       int[][] board = {{4,1,2},{5,0,3}};

        slidingPuzzle773 puzzle773 = new slidingPuzzle773();

        int i = puzzle773.slidingPuzzle(board);
        System.out.println(i);
    }

    public int slidingPuzzle(int[][] board) {

        int len = 0;

        int[][] moves = {
                {1,3},
                {0,2,4},
                {1,5},
                {0,4},
                {1,3,5},
                {2,4}};

        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        String str = this.array2Str(board);
        queue.add(str);
        visited.add(str);


        while (!queue.isEmpty()){


            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                if(poll.equals("123450")){
                    return len;
                }

                int zeroIndex = poll.indexOf('0');

                int[] move = moves[zeroIndex];

                for (int j = 0; j < move.length; j++) {

                    String target = swap(poll, zeroIndex, move[j]);
                    if(!visited.contains(target)){
                        visited.add(target);
                        queue.add(target);
                    }


                }

            }
            len++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    private String array2Str(int[][] board) {

        String str = "";
        for (int[] ints : board) {
            for (int anInt : ints) {
                str+=anInt;
            }

        }
        return str;
    }



}
