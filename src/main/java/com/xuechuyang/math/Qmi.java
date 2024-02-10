package com.xuechuyang.math;

/**
 * @author ChuYang
 * @version 1.0
 */
public class Qmi {
    static final int mod = 998244353;

    static long qmi(long a, long b) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }
}

