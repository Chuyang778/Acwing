package com.xuechuyang.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */

/**
 * 每个物品选还是不选
 */

public class ZeroOne {
    static final int N = 1005;
    static int n, m;
    static int[] v, w, f;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        v = new int[N];
        w = new int[N];
        f = new int[N];
        n = FastReader.nextInt();
        m = FastReader.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = FastReader.nextInt();
            w[i] = FastReader.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        out.println(f[m]);
        out.flush();
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