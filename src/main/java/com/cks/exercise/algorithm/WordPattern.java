package com.cks.exercise.algorithm;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "北京 杭州 杭州 北京";
        System.out.println(wordPattern(pattern, str));
    }

    public static Boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = Maps.newHashMap();
        Set<String> set = Sets.newHashSet();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            } else {
                set.add(strs[i]);
                map.put(pattern.charAt(i), strs[i]);
                if (set.size() != map.size()) {
                    return false;
                }
            }
        }
        return true;
    }
}
