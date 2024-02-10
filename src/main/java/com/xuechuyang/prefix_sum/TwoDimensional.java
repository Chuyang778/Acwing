package com.xuechuyang.prefix_sum;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class TwoDimensional {
    static final int N = 1010;
    static int n, m, q;
    static int[][] s;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        s = new int[N][N];
        n = FastReader.nextInt();
        m = FastReader.nextInt();
        q = FastReader.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = FastReader.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }
        while (q-- > 0) {
            int x1 = FastReader.nextInt();
            int y1 = FastReader.nextInt();
            int x2 = FastReader.nextInt();
            int y2 = FastReader.nextInt();
            out.println(get(x1, y1, x2, y2));
        }
        out.flush();
    }


    public static int get(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
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
