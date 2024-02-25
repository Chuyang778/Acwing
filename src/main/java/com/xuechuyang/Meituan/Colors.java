package com.xuechuyang.Meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Colors {
    static final PrintWriter out = new PrintWriter(System.out);
    static int n;

    static final int N = 100005;
    static List<List<Integer>> graphs;
    static String colors;
    static int[] red, blue, green;

    public static void main(String[] args) {
        n = FastReader.nextInt();
        graphs = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graphs.add(new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            int x = FastReader.nextInt();
            graphs.get(i).add(x);
            graphs.get(x).add(i);
        }
        colors = FastReader.next();
        colors = " " + colors;
        red = new int[N];
        blue = new int[N];
        green = new int[N];
        dfs(1, -1);
        for (int i = 1; i <= n; i++) {
            out.printf("%d %d %d\n",red[i],green[i],blue[i]);
        }
        out.flush();
    }

    public static void dfs(int u, int fa) {
        red[u] = colors.charAt(u) == 'R' ? 1 : 0;
        green[u] = colors.charAt(u) == 'G' ? 1 : 0;
        blue[u] = colors.charAt(u) == 'B' ? 1 : 0;
        for (int to : graphs.get(u)) {
            if (to == fa) {
                continue;
            }
            dfs(to, u);
            red[u] += red[to];
            green[u] += green[to];
            blue[u] += blue[to];
        }
    }

}

class FastReader {
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
