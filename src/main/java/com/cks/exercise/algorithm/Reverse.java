package com.cks.exercise.algorithm;

/**
 * @Author: cks
 * @Date: Created by 下午8:22 2021/6/29
 * @Package: com.cks.exercise.algorithm
 * @Description:
 */
public class Reverse {
    public static void main(String[] args) {
        int num = -4567;
        int c = 0;
        while (num != 0) {
            int temp = c;   //临时记录c 用于判断是否溢出
//            int a = num % 10;
            c = c * 10 + num % 10;
            num /= 10;
            if (c / 10 != temp) {  //如果c/10和临时记录并不相等，说明已经溢出了 结束循环
                c = 0;
                break;
            }
        }
        System.out.println(Long.MAX_VALUE + "反转后:" + c);
//        String s = "000000000123456";
//        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        long res = 0;
        boolean isNegtive = false;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    isNegtive = true;
                    continue;
                } else if (s.charAt(i) == '+') {
                    continue;
                }
            }
            if (Character.isDigit(s.charAt(i))) {
                int number = s.charAt(i) - '0';
                res = res * 10 + number;
                if (!isNegtive) {
                    // 判断是否超限
                    if (res > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    // 判断是否超限
                    if (res * -1 < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                return isNegtive ? (int) res * -1 : (int) res;
            }
        }
        return isNegtive ? (int) res * -1 : (int) res;
    }
}
