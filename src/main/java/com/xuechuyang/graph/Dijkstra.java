package com.xuechuyang.graph;

import java.io.*;
import java.util.*;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Dijkstra {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static final Scanner scanner = new Scanner(System.in);
    static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static final int N = 1000010;
    static int n, m;

    static int[] h, w, e, ne;
    static int idx;
    static int[] dist;
    static boolean[] st;

    public static void main(String[] args) {
        n = FastReader.nextInt();
        m = FastReader.nextInt();
        h = new int[N];
        w = new int[N];
        e = new int[N];
        ne = new int[N];
        dist = new int[N];
        st = new boolean[N];
        Arrays.fill(h, -1);
        Arrays.fill(dist, 0x3f);
        while (m-- > 0) {
            int a = FastReader.nextInt();
            int b = FastReader.nextInt();
            int c = FastReader.nextInt();
            add(a, b, c);
        }
        out.println(dijkstra());
        out.flush();
    }

    static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static int dijkstra() {
        dist[1] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.add(new int[]{1, 0});

        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            int distance = poll[1];
            int ver = poll[0];
            if (st[ver]) {
                continue;
            }
            st[ver] = true;
            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[ver] + w[i]) {
                    dist[j] = dist[ver] + w[i];
                    heap.add(new int[]{j, dist[j]});
                }
            }
        }
        if (dist[n] == 0x3f3f3f3f) {
            return -1;
        }
        return dist[n];
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
