package com.xuechuyang.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class ColorOnTree {
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static final int N = 100005;
    static int n;
    static int[] w;
    static int[][] f;
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        n = FastReader.nextInt();
        w = new int[N];
        f = new int[N][2];
        graph = new ArrayList<>(N);
        for (int i = 1; i <= n; i++) {
            w[i] = FastReader.nextInt();
        }
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n - 1; i++) {
            int u = FastReader.nextInt();
            int v = FastReader.nextInt();
            add(u, v);
        }

        dfs(1, -1);
        out.println(Math.max(f[1][0], f[1][1]));
        out.flush();
    }

    public static void dfs(int u, int fa) {
        for (int to : graph.get(u)) {
            if (to == fa) {
                continue;
            }
            dfs(to, u);
        }
        for (int to : graph.get(u)) {
            if (to == fa) {
                continue;
            }
            f[u][0] += Math.max(f[to][0], f[to][1]);
        }
        for (int to : graph.get(u)) {
            if (to == fa) {
                continue;
            }
            if (!check(w[u], w[to])) {
                continue;
            }
            f[u][1] = Math.max(f[u][1], f[u][0] - Math.max(f[to][0], f[to][1]) + f[to][0] + 2);
        }
    }

    public static void add(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static boolean check(long a, long b) {
        long sqrt = (long) Math.sqrt(a * b);
        return sqrt * sqrt == a * b;
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

    public static double nextDouble() {
        return Double.parseDouble(next());
    }

    public static Long nextLong() {
        return Long.parseLong(next());
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
