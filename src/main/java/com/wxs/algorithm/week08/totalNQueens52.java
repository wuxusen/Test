package com.wxs.algorithm.week08;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-05-08
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class totalNQueens52 {


    public static void main(String[] args) {
        totalNQueens52 totalNQueens52 = new totalNQueens52();
        int i = totalNQueens52.totalNQueue1(4);
        System.out.println(i);
    }

    public int totalNQueens1(int n) {

        boolean[] cols = new boolean[n];
        boolean[] pie = new boolean[2 * n - 1];
        boolean[] na = new boolean[2 * n - 1];


        return backtrack(0, n, 0, cols, pie, na);

    }

    private int backtrack(int row, int n, int count, boolean[] cols, boolean[] pie, boolean[] na) {
        if (row == n) {
            count++;
            return count;
        }

        for (int col = 0; col < n; col++) {

            if (!cols[col] && !pie[row + col] && !na[row - col + n - 1]) {

                cols[col] = true;
                pie[row + col] = true;
                na[row - col + n - 1] = true;


                count = backtrack(row + 1, n, count, cols, pie, na);


                cols[col] = false;
                pie[row + col] = false;
                na[row - col + n - 1] = false;
            }
        }
        return count;
    }


    private int size;
    private int count;


    /**
     *   1. 将 x 最右边的 n 位清零:x & (~0 << n)
     * * 2. 获取 x 的第 n 位值(0 或者 1): (x >> n) & 1
     * * 3. 获取 x 的第 n 位的幂值:x & (1 << (n -1))
     * * 4. 仅将第 n 位置为 1:x | (1 << n)
     * * 5. 仅将第 n 位置为 0:x & (~ (1 << n))
     * * 6. 将 x 最高位至第 n 位(含)清零:x & ((1 << n) - 1)
     * * 7. 将第 n 位至第 0 位(含)清零:x & (~ ((1 << (n + 1)) - 1))
     *
     * @param row
     * @param ld
     * @param rd
     */
    private void solve(int row, int ld, int rd) {

        System.out.println("row >> " +Integer.toBinaryString(row) + " ，ld >> "  + Integer.toBinaryString(ld)+" ，rd >> "  + Integer.toBinaryString(rd));

        if (row == size) {
            count++;
            return;
        }

        int pos = size & (~(row | ld | rd));

        System.out.println("可以放置皇后的位置 >>" + Integer.toBinaryString(pos));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            System.out.println("while pos>>" + Integer.toBinaryString(pos));
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }




    public int totalNQueue1(int n){
        count = 0;
        size = (1 << n)-1;
        solve1(0,0,0);
        return count;
    }

    private void solve1(int row, int ld, int rd) {

        if(row == size){
            count++;
            return;
        }
        // 取可以放皇后的位置
        int pos =size &  (~(row|ld|rd)) ;
        while (pos != 0){
            int p = pos & (-pos); // 获取最后以为1，组成二进制，可以放的皇后的位置
            pos = pos &(pos -1); // 把最后一个1置为0，下次使用
            solve1(row|p,(ld|p) << 1,(rd|p) >> 1);
        }

    }


}
