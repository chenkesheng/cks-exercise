package com.cks.exercise.algorithm;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author: cks
 * @Date: Created by 下午2:27 2021/6/23
 * @Package: com.cks.exercise.algorithm
 * @Description: 无重复字符的最长子串，快慢指针
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("HELLO_HAOWU_MALL","30");
//        String object = jsonObject.getString("HELLO_HAOWU_MALL");
//        System.out.println(object);
        System.out.println(new BigDecimal(0).equals(BigDecimal.ZERO) );
        List<Integer> skuList = Lists.newArrayList();
//       Integer integer = skuList.stream().min(Integer::compareTo).get();
//        System.out.println(integer);
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> stringList = streamOfwords
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
//                .distinct()
                .collect(toList());

        System.out.print(String.join("", stringList).toString());

        String s = "cbbd";
//        if (s == null || "".equals(s)) {
//            System.out.println(0);
//        }
//        if (s.length() == 1) {
//            System.out.println(1);
//        }
//        char[] array = s.toCharArray();
//        int maxLength = 0;
//        int pre = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = pre; j < i; j++) {
//                if (array[i] == array[j]) {
//                    pre = j + 1;
//                    break;
//                }
//            }
//            int result = i - pre + 1;
//            if (result > maxLength) {
//                maxLength = result;
//            }
//        }
//        System.out.println(maxLength);
//        lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] array = s.toCharArray();
        int maxLength = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = pre; j < i; j++) {
                if (array[i] == array[j]) {
                    pre = j + 1;
                    break;
                }
            }
            int result = i - pre + 1;
            if (result > maxLength) {
                maxLength = result;
            }
        }
        return maxLength;
    }
}
