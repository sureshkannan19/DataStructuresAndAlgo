package org.sk.binarysearch;

import java.util.*;

public class TimeMap {

    private String key;
    private String value;
    private int timestamp;

    private final Map<String, TreeMap<Integer, String>> keyValueStoreMap;

    public TimeMap() {
        this.keyValueStoreMap = new HashMap<>();
    }


    public void set(String key, String value, int timestamp) {
        keyValueStoreMap.computeIfAbsent(key, t -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> result = keyValueStoreMap.get(key);
        if (result != null) {
            Map.Entry<Integer, String> entry = result.floorEntry(timestamp);
            if (entry != null) {
                return entry.getValue();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMap t = new TimeMap();
        t.set("love", "high", 10);
        t.set("love", "low", 20);
        System.out.println(t.get("love", 5));
        System.out.println(t.get("love", 10));
        System.out.println(t.get("love", 15));
        System.out.println(t.get("love", 20));
        System.out.println(t.get("love", 25));

        t = new TimeMap();
        t.set("a", "bar", 1);
        t.set("x", "b", 3);
        System.out.println(t.get("b", 3));
        t.set("foo", "bar2", 4);
        System.out.println(t.get("foo", 4));
        System.out.println(t.get("foo", 5));
    }

}