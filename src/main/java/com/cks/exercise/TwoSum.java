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
     int [] s = new int[]{1,2,3,4,5,6,7};
     int [] a = new int[]{1,2,3,4,5,6};
     int result = a.length/2;
     System.out.println(result);
     double r = a[result-1] + a[result];
     double res = (r/2);
        System.out.println(res);

    }
}
