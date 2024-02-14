package com.xuechuyang.MinimumSpanningTree;



import java.io.*;
import java.util.*;

/**
 * @author ChuYang
 * @version 1.0
 */

public class LiaisonOfficer {
    static int n, m;
    static final int N = 100010;
    static final int INF = 1000000007;

    static int[] p;
    static List<Edge> edges = new ArrayList<>(N);
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
        p = new int[N];
        n = FastReader.nextInt();
        m = FastReader.nextInt();
        for (int i = 0; i < m; i++) {
            int s = FastReader.nextInt();
            int a = FastReader.nextInt();
            int b = FastReader.nextInt();
            int w = FastReader.nextInt();
            edges.add(new Edge(s, a, b, w));
        }
        out.println(kruskal());
        out.flush();
    }

    public static int kruskal() {
        Collections.sort(edges, (o1, o2) -> {
            if (o1.getS() != o2.getS()) {
                return Integer.compare(o1.getS(), o2.getS());
            }
            return Integer.compare(o1.getW(), o2.getW());
        });
        int res = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int s = edges.get(i).getS();
            int a = edges.get(i).getA();
            int b = edges.get(i).getB();
            int w = edges.get(i).getW();
            a = find(a);
            b = find(b);
            if (a != b || s == 1) {
                p[a] = b;
                res += w;
            }
        }
        return res;
    }

    public static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}

class Edge {
    private int s;
    private int a;
    private int b;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    private int w;

    public Edge() {
    }

    public Edge(int s, int a, int b, int w) {
        this.s = s;
        this.a = a;
        this.b = b;
        this.w = w;
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
