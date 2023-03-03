package com.cks.exercise.algorithm;

/**
 * @Author: cks
 * @Date: Created by 下午5:20 2021/7/6
 * @Package: com.cks.exercise.algorithm
 * @Description: 回文数
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int num = 0;
        int source = x;
        if (source < 0) {
            return false;
        }
        while (source != 0) {
            int temp = num;
            num = num * 10 + source % 10;
            source = source / 10;
            if (num / 10 != temp) {
                num = 0;
                break;
            }
        }
        return x == num;
    }
}
