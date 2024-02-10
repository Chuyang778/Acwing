package com.xuechuyang.kmp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChuYang
 * @version 1.0
 */
public class KMP {
    public static void main(String[] args) {
        List<Integer> index = getIndex("ababa", "aba");
        index.forEach(System.out::println);
    }

    //S为长串,T为短串
    public static List<Integer> getIndex(String S, String T) {
        int n = T.length();
        int m = S.length();
        S = " " + S;
        T = " " + T;
        List<Integer> ans = new ArrayList<>();
        int[] ne = new int[n + 1];
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && T.charAt(j + 1) != T.charAt(i)) {
                j = ne[j];
            }
            if (T.charAt(j + 1) == T.charAt(i)) {
                j++;
            }
            ne[i] = j;
        }

        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && T.charAt(j + 1) != S.charAt(i)) {
                j = ne[j];
            }
            if (T.charAt(j + 1) == S.charAt(i)) {
                j++;
            }
            if (j == n) {
                ans.add(i - n);
                j = ne[j];
            }
        }
        return ans;
    }
}

