package com.xuechuyang.difference;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author ChuYang
 * @version 1.0
 */
public class DoubleDimensional {
    static final int N = 1010;
    static int n, m, q;
    static int[][] a, b;
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        n = FastReader.nextInt();
        m = FastReader.nextInt();
        q = FastReader.nextInt();
        a = new int[N][N];
        b = new int[N][N];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = FastReader.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(i, j, i, j, a[i][j]);
            }
        }
        while (q-- > 0) {
            int x1 = FastReader.nextInt();
            int y1 = FastReader.nextInt();
            int x2 = FastReader.nextInt();
            int y2 = FastReader.nextInt();
            int c = FastReader.nextInt();
            insert(x1, y1, x2, y2, c);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                out.printf("%d ",b[i][j]);
            }
            out.println();
        }
        out.flush();
    }

    public static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
