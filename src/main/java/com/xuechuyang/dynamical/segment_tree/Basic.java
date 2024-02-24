package com.xuechuyang.dynamical.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Basic {
    static final int N = 100010;
    static int n, m;
    static int[] a, tr;

    public static void init() {
        a = new int[N];
        tr = new int[N];
    }

    public static int lowbit(int x) {
        return x & -x;
    }

    public static void add(int x, int v) {
        for (int i = x; i < N; i += lowbit(i)) {
            tr[i] += v;
        }
    }

    public static int get(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

}

class FastReader {
    private static StringTokenizer st;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(bufferedReader.readLine());
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
