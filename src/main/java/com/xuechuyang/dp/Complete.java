package com.xuechuyang.dp;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Complete {
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
            for (int j = v[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        out.println(f[m]);
        out.flush();
    }
}

