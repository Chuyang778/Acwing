package com.xuechuyang.Newcoder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class BinarySystemTree {
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static final int N = 100005;
    static int n;
    static String str;
    static List<List<Integer>> graph;
    static int[] f;

    public static void main(String[] args) {
        n = FastReader.nextInt();
        str = FastReader.next();
        str = " " + str;
        f = new int[n + 5];
        graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = FastReader.nextInt();
            int v = FastReader.nextInt();
            add(u, v);
        }
        dfs(1, -1);
        for (int i = 1; i <= n; i++) {
            out.println(f[i]);
        }
        out.flush();
    }

    static int dfs(int u, int fa) {
        int sum = 0;
        for (int to : graph.get(u)) {
            if (to == fa) {
                continue;
            }
            if (str.charAt(to) == '1') {
                sum++;
            }
            sum += dfs(to, u);
        }
        f[u] = sum;
        return sum;
    }

    static void add(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}

class FastReader {
    private static StringTokenizer stringTokenizer;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String next() {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }

    public static int nextInt() {
        return Integer.parseInt(next());
    }

    public static double nextDouble() {
        return Double.parseDouble(next());
    }

    public static long nextLong() {
        return Long.parseLong(next());
    }

    public static String nextLine() {
        String str = "";
        try {
            str = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
