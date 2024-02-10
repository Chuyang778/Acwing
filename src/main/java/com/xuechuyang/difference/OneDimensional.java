package com.xuechuyang.difference;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class OneDimensional {
    static final int N = 100010;
    static int n, m;
    static int[] a, b;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        n = FastReader.nextInt();
        m = FastReader.nextInt();
        a = new int[N];
        b = new int[N];
        for (int i = 1; i <= n; i++) {
            a[i] = FastReader.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            insert(i, i, a[i]);
        }
        while (m-- > 0) {
            int l = FastReader.nextInt();
            int r = FastReader.nextInt();
            int c = FastReader.nextInt();
            insert(l, r, c);
        }
        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            if (i != n) {
                out.printf("%d ", b[i]);
            } else {
                out.printf("%d", b[i]);
            }
        }
        out.flush();
    }


    public static void insert(int l, int r, int c) {
        b[l] += c;
        b[r + 1] -= c;
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