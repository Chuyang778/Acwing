package com.xuechuyang.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class TreasureHunt {
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int n, m, k;
    static final int N = 55, mod = 1000000007;
    static int[][] w;
    static int[][][][] f;

    public static void main(String[] args) {
        n = MyFastReader.nextInt();
        m = MyFastReader.nextInt();
        k = MyFastReader.nextInt();
        w = new int[N][N];
        f = new int[N][N][13][14];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                w[i][j] = MyFastReader.nextInt();
                w[i][j]++;
            }
        }
        f[1][1][1][w[1][1]] = 1;
        f[1][1][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                for (int u = 0; u <= k; u++) {
                    for (int v = 0; v <= 13; v++) {
                        f[i][j][u][v] = (f[i][j][u][v] + f[i - 1][j][u][v]) % mod;
                        f[i][j][u][v] = (f[i][j][u][v] + f[i][j - 1][u][v]) % mod;
                        if (u > 0 && v == w[i][j]) {
                            for (int c = 0; c < v; c++) {
                                f[i][j][u][v] = (f[i][j][u][v] + f[i - 1][j][u - 1][c]) % mod;
                                f[i][j][u][v] = (f[i][j][u][v] + f[i][j - 1][u - 1][c]) % mod;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= 13; i++) {
            res = (res + f[n][m][k][i]) % mod;
        }
        out.println(res);
        out.flush();
    }
}

class MyFastReader {
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
