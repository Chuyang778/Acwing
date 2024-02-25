package com.xuechuyang.hand;

import java.util.BitSet;

/**
 * @author ChuYang
 * @version 1.0
 */
public class BloomFilter {
    private static final int DEFUALT_SIZE = 256 << 22;

    private static final int[] seeds = {3, 5, 7, 11, 13, 37, 61};

    private static HashFunction[] functions = new HashFunction[seeds.length];

    private static BitSet bitset = new BitSet(DEFUALT_SIZE);

    private static class HashFunction {
        private int size;
        private int seed;

        public HashFunction(int size, int seed) {
            this.size = size;
            this.seed = seed;
        }

        public int hash(String value) {
            int result = 0;
            int len = value.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + value.charAt(i);
            }
            return result & (size - 1);
        }

    }

    public static void add(String value) {
        if (value != null) {
            for (HashFunction f : functions) {
                bitset.set(f.hash(value), true);
            }
        }
    }

    public static boolean contains(String value) {
        if (value == null) {
            return false;
        }
        for (HashFunction f : functions) {
            if (!bitset.get(f.hash(value))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i = 0; i < seeds.length; i ++){
            functions[i] = new HashFunction(DEFUALT_SIZE, seeds[i]);
        }
        add("affcasc");
        System.out.println(contains("affcasc"));
    }
}
