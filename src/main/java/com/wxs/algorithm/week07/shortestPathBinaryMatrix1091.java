package com.wxs.algorithm.week07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-30
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class shortestPathBinaryMatrix1091 {


    public static void main(String[] args) {

       /* int[][] grid = {{0,0,0,0,1},
                        {1,0,0,0,0},
                        {0,1,0,1,0},
                        {0,0,0,1,1},
                        {0,0,0,1,0}};*/


       int[][] grid = {{0,0,0},
                       {1,1,0},
                       {1,1,0}};


        shortestPathBinaryMatrix1091 shor = new shortestPathBinaryMatrix1091();

        int i = shor.shortestPathBinaryMatrix1(grid);
        System.out.println(i);


    }


    public int shortestPathBinaryMatrix(int[][] grid) {

        int rowSize = grid.length;
        int colSize = grid[0].length;


        if(grid[0][0] == 1 || grid[rowSize-1][colSize - 1] == 1){
            return -1;
        }

        grid[0][0] = 1;
        Queue<String> queue = new LinkedList<>();

        queue.add("0_0");


        int len = 0;
        while (!queue.isEmpty()){
            len++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();
                int index =  curr.indexOf("_");
                int row = new Integer(curr.substring(0, index));
                int col = new Integer(curr.substring(index+1));

                if(row == (rowSize - 1) && col == (colSize -1)){
                    return len;
                }

                //定义八通数组
                int[][] dire = {{row+1,col},{row - 1,col},{row,col+1},{row,col - 1},
                                {row+1,col+1},{row-1,col+1},{row-1,col-1},{row+1,col -1}
                                };

                for (int j = 0; j < dire.length; j++) {



                    if(dire[j][0] >= 0 && dire[j][0] < rowSize && dire[j][1] >= 0 && dire[j][1] < colSize && grid[dire[j][0]][dire[j][1]] == 0 ){
                        queue.add(dire[j][0]+"_"+dire[j][1]);
                        grid[dire[j][0]][dire[j][1]] = 1;
                    }

                }
            }
        }

        return -1;

    }

    public int shortestPathBinaryMatrix1(int[][] grid) {

        int rowSize = grid.length;
        int colSize = grid[0].length;


        if(grid[0][0] == 1 || grid[rowSize-1][colSize - 1] == 1){
            return -1;
        }

        grid[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        int len = 0;
        while (!queue.isEmpty()){

            len++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();

                int row = poll[0];
                int col = poll[1];

              /*  int[][] dire = {{ row+1,col+1}, {row,col + 1},{row-1,col+1},
                                {row-1,col},{row-1,col - 1},
                                {row,col -1},{row+1,col-1},{row+1,col}};*/

                if(row == (rowSize-1) && col == (colSize-1)){
                    return len;
                }

                //定义八通数组
                int[][] dire = {{row+1,col},{row - 1,col},{row,col+1},{row,col - 1},
                        {row+1,col+1},{row-1,col+1},{row-1,col-1},{row+1,col -1}
                };


                for (int j = 0; j < dire.length; j++) {

                    if(dire[j][0] >=0 && dire[j][0] < rowSize && dire[j][1] >=0 && dire[j][1] < colSize
                            && grid[dire[j][0]][dire[j][1]] == 0){

                        grid[dire[j][0]][dire[j][1]] = 1;
                        queue.add(new int[]{dire[j][0],dire[j][1]});

                    }
                }
            }
        }
        return -1;
    }

}
