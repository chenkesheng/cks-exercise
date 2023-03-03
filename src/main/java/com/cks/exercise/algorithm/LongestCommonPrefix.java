package com.cks.exercise.algorithm;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: cks
 * @Date: Created by 下午2:07 2021/8/3
 * @Package: com.cks.exercise.algorithm
 * @Description:
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        String result = strs[0];
        for (String str : strs) {
            if (str.length() >= result.length()) {
                result = str;
            }
        }
        String res = result;
        outterLoop:
        for (int i = 0; i < res.length(); i++) {
            for (String str : strs) {
                if (!str.startsWith(res)) {
                    res = res.substring(0, i);
                    break outterLoop;
                }
            }
        }
//        ThreadPoolExecutor
        System.out.println(res);
//        String[] s = result.split("");
//        StringBuilder data = new StringBuilder();

//        outterLoop:
//        for (String value : s) {
//            data.append(value);
//            for (String str : strs) {
//                if (!str.startsWith(data.toString())) {
//                    break outterLoop;
//                }
//            }
//        }
//        System.out.println(data.substring(0, data.toString().length() - 1));
        }

//    public String getShortUrl(String url) {
//        long shortUrlSeed = jedis.incr("short_url_seed");
//
//        StringBuffer buffer = new StringBuffer();
//        while(shortUrlSeed > 0) {
//            buffer.append(X36_ARRAY[(int)(shortUrlSeed % 36)]);
//            shortUrlSeed = shortUrlSeed / 36;
//        }
//        //获取到短链接
//        String shortUrl = buffer.reverse().toString();
//        return shortUrl;
//    }
    }
