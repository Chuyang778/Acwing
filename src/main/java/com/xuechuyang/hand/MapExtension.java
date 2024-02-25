package com.xuechuyang.hand;

import cn.hutool.crypto.asymmetric.KeyType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ChuYang
 * @version 1.0
 */
public class MapExtension {
    public static void main(String[] args) {
    }
}

class MultiMap<K, V> {
    private Map<K, MultiValueContainer<V>> map = new HashMap<>();

    public void put(K key, V value) {
        map.computeIfAbsent(key, k -> new MultiValueContainer<>()).addValue(value);
    }

    public List<V> get(K key) {
        return map.getOrDefault(key, null).getValues();
    }
}

class MultiValueContainer<V> {
    private List<V> values = new ArrayList<>();

    public void addValue(V value) {
        values.add(value);
    }

    public List<V> getValues() {
        return values;
    }
}
