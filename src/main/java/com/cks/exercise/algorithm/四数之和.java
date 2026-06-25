package com.cks.exercise.algorithm;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    public static void main(String[] args) {
        int[] nums = new int[]{-3,-1,0,2,4,5};
        System.out.println(fourSum(nums, 0));
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = Lists.newArrayList();
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        Arrays.sort(nums); // 排序

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // 去重
                }
                int partSum = nums[i] + nums[j];
                int L = i + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = partSum + nums[L] + nums[R];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[++L]) {
                            L++; // 去重
                        }
                        while (L < R && nums[R] == nums[--R]) {
                            R--; // 去重
                        }
                        L++;
                        R--;
                    } else if (sum < target) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return result;
    }
}
