package com.xuechuyang.Alibaba;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Travel {
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static final int N = 100005;
    static int n, q;
    static int[] t, s;

    public static void main(String[] args) {
        n = FastReader.nextInt();
        q = FastReader.nextInt();
        t = new int[N];
        s = new int[N];
        for (int i = 1; i <= n; i++) {
            t[i] = FastReader.nextInt();
        }
        int sum = Arrays.stream(t).sum();
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + t[i];
        }
//        for (int i = 1; i <= n; i++) {
//            System.out.printf("%d ", s[i]);
//        }
//        System.out.println();
        while (q-- > 0) {
            int time = FastReader.nextInt();
            time = get(time, sum);
//            System.out.println(time);
            out.println(getAns(time));
        }
        out.flush();
    }

    static int get(int time, int sum) {
        return time % sum;
    }

    static int getAns(int time) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (time < s[mid]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

class FastReader {
    private static StringTokenizer st;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
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
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
