package com.cks.exercise.algorithm;

/**
 * @Author: cks
 * @Date: Created by 下午2:23 2021/6/24
 * @Package: com.cks.exercise.algorithm
 * @Description:
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome2(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int maxLength = 0;
        String res = "";
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLength && valid(s, i, j)) {
                    maxLength = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    private static boolean valid(String s, int left, int right) {
        // 验证子串 s[left, right] 是否为回文串
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

    public static String longestPalindrome2(String s) {
        int sLen = s.length();
        int maxLen = 0;
        String ans = "";
        boolean[][] P = new boolean[sLen][sLen];
        // 遍历所有长度
        for (int len = 1; len <= sLen; len++) {
            for (int start = 0; start < sLen; start++) {
                int end = start + len - 1;
                // 下标越界，结束循环
                if (end >=sLen) {
                    break;
                }
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                if (P[start][end] && len > maxLen) {
                    maxLen = len;
                    ans = s.substring(start, end + 1);
                }
            }
        }
        return ans;
    }
}
