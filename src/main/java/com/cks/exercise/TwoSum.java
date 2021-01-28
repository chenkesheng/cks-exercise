package com.cks.exercise;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * @Author: cks
 * @Date: Created by 15:05 2018/8/27
 * @Package: com.cks.exercise
 * @Description:
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i + 1;
                    index2 = j + 1;
                }
            }
        }
        int[] result = new int[]{index1, index2};
        System.out.println(index1 + "+" + index2);
        return result;
    }

    public static void main(String[] args) {
        int[] s = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
//        int result = a.length / 2;
//        System.out.println(result);
//        double r = a[result - 1] + a[result];
//        double res = (r / 2);
//        System.out.println(res);

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static int[] twoSumTest(int[] nums, int target) {

//        for (int i = 0; i < nums.length; i++) {
//            int x = target - nums[i];
//            for (int j = 0; j < nums.length; j++) {
//                if (x == nums[j] && i != j) {
//                    return new int[]{i, j};
//                }
//            }
//        }

        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (maps.get(target - nums[i]) != null) {
                return new int[]{maps.get(target - nums[i]), i};
            }
            maps.put(nums[i], i);
        }
        return null;
    }

//    public List<List<Integer>> combine(int n, int k) {
//        List<Integer> a = new ArrayList<>();
//        List<List<Integer>> b = new ArrayList<>();
//        for (int i = 1; i < n; i++) {
//            a.add(i, k);
//            for (int j = 1; j < k; j++) {
//                a.add(i)
//            }
//        }
//
//        return null;
//    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // 实现 m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i 太小，需要增大
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i 太大，需要减小
            } else { // i 为合适值，根据不同情况返回不同值
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
