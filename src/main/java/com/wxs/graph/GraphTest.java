package com.wxs.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2019-08-21
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class GraphTest {


    public static void main(String[] args) {


        GraphTest graphTest = new GraphTest(8);
        graphTest.addEdge(0, 1);
        graphTest.addEdge(0, 3);
        graphTest.addEdge(1, 2);
        graphTest.addEdge(1, 4);
        graphTest.addEdge(3, 4);
        graphTest.addEdge(4, 6);
        graphTest.addEdge(4, 5);
        graphTest.addEdge(2, 5);
        graphTest.addEdge(5, 7);
        graphTest.addEdge(6, 7);

        System.out.println("");
        System.out.print("广度优先算法：");
        graphTest.bfs(0, 6);

        System.out.println("");

        System.out.print("深度优先算法：");
        graphTest.dfs(0, 6);
        System.out.println("");


    }

    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public GraphTest(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }


    public void bfs(int s, int t) {
        if (s == t) return;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");

    }


    // ---------------------------------深度优先算法-------------------------------

    boolean found = false; // 全局变量或者类成员变量

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }


}
