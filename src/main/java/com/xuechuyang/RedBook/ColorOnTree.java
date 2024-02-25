package com.xuechuyang.RedBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class ColorOnTree {
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
