package org.sk.arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyValueMap = new HashMap<>();
        for (String str : strs) {
            String s = getKey(str, new char[26]);
            keyValueMap.computeIfAbsent(s, (v) -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(keyValueMap.values());
    }

    private String getKey(String str, char[] asc) {
        for (char ch : str.toCharArray()) {
            asc[ch - 'a']++;
        }
        return new String(asc);
    }

    public static void main(String[] args) {
        GroupAnagram ga = new GroupAnagram();
        System.out.println(ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(ga.groupAnagrams(new String[]{"bdddddddddd", "bbbbbbbbbbc"}));
        System.out.println(ga.groupAnagrams(new String[]{"ddddddddddg", "dgggggggggg"}));
    }
}