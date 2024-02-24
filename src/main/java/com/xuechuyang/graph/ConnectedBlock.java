package com.xuechuyang.graph;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class ConnectedBlock {
    static final int N = 200005;
    static String str;
    static int n;
    static List<List<Integer>> graphs;
    static int[] red, blue, f;
    static boolean[] visited;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        n = MyFastReader.nextInt();
        str = MyFastReader.next();
        str = " " + str;
        graphs = new ArrayList<>(N);
        red = new int[N];
        blue = new int[N];
        f = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graphs.add(new ArrayList<>());
        }
        for (int i = 1; i <= n - 1; i++) {
            int u = MyFastReader.nextInt();
            int v = MyFastReader.nextInt();
            add(u, v);
            add(v, u);
        }
        dfs(1, -1);
        for (int i = 1; i <= n; i++) {
            out.printf("red[%d]:%d,blue[%d]:%d\n", i, red[i], i, blue[i]);
        }
        out.flush();
    }

    /**
     * 求每个节点(包含当前节点)两种不同颜色连通快的数目
     * @param u
     * @param fa
     */
    public static void dfs(int u, int fa) {
        visited[u] = true;
        red[u] = str.charAt(u) == 'R' ? 1 : 0;
        blue[u] = str.charAt(u) == 'B' ? 1 : 0;
        for (int neighbor : graphs.get(u)) {
            if (!visited[neighbor] && neighbor != fa) {
                dfs(neighbor, u);
                red[u] = red[neighbor];
                blue[u] = blue[neighbor];
            }
        }
    }

    public static void add(int u, int v) {
        graphs.get(u).add(v);
    }
}


class MyFastReader {
    private static StringTokenizer st;

    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(bf.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public static int nextInt() {
        return Integer.parseInt(next());
    }

    public static long nextLong() {
        return Long.parseLong(next());
    }

    public static double nextDouble() {
        return Double.parseDouble(next());
    }

    public static String nextLine() {
        String str = "";
        try {
            str = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}