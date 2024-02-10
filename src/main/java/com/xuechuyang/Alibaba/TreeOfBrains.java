package com.xuechuyang.Alibaba;

import java.io.*;
import java.util.*;

/**
 * @author ChuYang
 * @version 1.0
 */
public class TreeOfBrains {
    static final Scanner scanner = new Scanner(System.in);
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static final int INF = 0x3f3f3f3f;
    static final int N = 100005;
    static int[] dp, mn;
    static List<List<Integer>> graph;
    static int n;

    public static void main(String[] args) throws IOException {
        n = FastReader.nextInt();
        dp = new int[N];
        mn = new int[N];
        graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= n - 1; i++) {
            int u = FastReader.nextInt();
            int v = FastReader.nextInt();
            addEdge(u, v);
        }
        dfs(1, -1);
        for (int i = 1; i <= n; i++) {
            if (i != n) {
                out.printf("%d ", dp[i]);
            } else {
                out.printf("%d", dp[i]);
            }
        }
        out.flush();
    }

    private static int dfs(int v, int fa) {
        int min = INF;
        for (int to : graph.get(v)) {
            if (to == fa) {
                continue;
            }
            min = Math.min(min, dfs(to, v));
        }
        mn[v] = min;
        if (mn[v] == INF) {
            dp[v] = 1;
        } else {
            dp[v] = dp[mn[v]] + 1;
        }
        return Math.min(v, min);
    }

    public static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}
