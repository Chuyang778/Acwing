package com.xuechuyang.Lambda;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author ChuYang
 * @version 1.0
 */
public class MethodReference {
    public static void main(String[] args) {
        // Supplier的用法:无接受的参数返回T类型的值
        MyObject MyObject = (MyObject) get();
        Map map = MyObject.getMap();
        map.put(1, new String("abc"));
        map.put(new BigDecimal(1.2), true);
        map.forEach((k, v) -> System.out.println("k = " + k + " v = " + v));
    }

    public static Object get() {
        Supplier<Object> supplier = MyObject::new;
        return supplier.get();
    }

}

class MyObject<K, V> {
    private Map<K, V> map = new HashMap<>();

    public Map<K, V> getMap() {
        return map;
    }

    public void setMap(Map<K, V> map) {
        this.map = map;
    }

    public MyObject(Map<K, V> map) {
        this.map = map;
    }

    public MyObject() {
    }
}
