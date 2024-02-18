package lqb;

import java.io.*;
import java.util.*;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Average {
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<Integer>[] f;
    static long ans;

    public static void main(String[] args) {
        n = FastReader.nextInt();
        f = new ArrayList[15];
        for (int i = 0; i < n; i++) {
            f[i] = new ArrayList<>();
        }
        int c = n / 10;
        while (n-- > 0) {
            int a = FastReader.nextInt();
            int b = FastReader.nextInt();
            f[a].add(b);
        }
        for (int i = 0; i < 10; i++) {
            Collections.sort(f[i]);
        }
        for (int i = 0; i < 10; i++) {
            int size = f[i].size();
            if (size <= c) {
                continue;
            }
            for (int j = 0; j < size - c; j++) {
                ans += f[i].get(j);
            }
        }
        out.println(ans);
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
