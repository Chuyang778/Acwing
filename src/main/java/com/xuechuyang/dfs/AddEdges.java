package com.xuechuyang.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class AddEdges {
    static final int N = 10010;
    static List<List<Edge>> h;
    static int n;
    static int[] dist;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        n = FastReader.nextInt();
        h = new ArrayList<>(n + 5);
        dist = new int[n + 5];
        for (int i = 0; i < n + 5; i++) {
            h.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = FastReader.nextInt();
            int b = FastReader.nextInt();
            int c = FastReader.nextInt();
            h.get(a).add(new Edge(b, c));
            h.get(b).add(new Edge(a, c));
        }
        dfs(1, -1, 0);
        int u = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[u]) {
                u = i;
            }
        }
        dfs(u, -1, 0);
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[u]) {
                u = i;
            }
        }
        int s = dist[u];
        out.println(10 * s + (((long) 1 + s) * s) / 2);
        out.flush();
    }

    public static void dfs(int u, int father, int distance) {
        dist[u] = distance;
        for (Edge e : h.get(u)) {
            if (e.id != father) {
                dfs(e.id, u, distance + e.w);
            }
        }
    }

    static class Edge {
        int id;
        int w;

        public Edge(int id, int w) {
            this.id = id;
            this.w = w;
        }
    }
}

class FastReader {
    private static StringTokenizer st;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
