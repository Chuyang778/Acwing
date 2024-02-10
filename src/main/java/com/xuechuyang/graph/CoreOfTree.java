package com.xuechuyang.graph;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChuYang
 * @version 1.0
 */
public class CoreOfTree {
    static final int N = 100010, M = N << 1;
    static List<List<Integer>> h;
    static int n;
    static int ans = N;
    static boolean[] st;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        n = FastReader.nextInt();
        h = new ArrayList<>(N);
        st = new boolean[N];
        for (int i = 0; i < N; i++) {
            h.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = FastReader.nextInt();
            int b = FastReader.nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }
        dfs(1);
        out.println(ans);
        out.flush();
    }

    public static int dfs(int u) {
        int res = 0;
        st[u] = true;
        int sum = 1;
        for (int to : h.get(u)) {
            if (!st[to]) {
                int s = dfs(to);
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(ans, res);
        return sum;
    }

    public static void addEdge(int a, int b) {
        h.get(a).add(b);
        h.get(b).add(a);
    }

}
