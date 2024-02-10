package com.xuechuyang.math;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Prime {
    static final int N = 1000010;
    static int[] primes;
    static int cnt;
    static boolean[] st;

    public static void main(String[] args) {
        primes = new int[N];
        st = new boolean[N];
    }

    static void get_primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] * i <= n; j++) {
                st[primes[j] * i] = true;
                if(i % primes[j] == 0){
                    break;
                }
            }
        }
    }
}
