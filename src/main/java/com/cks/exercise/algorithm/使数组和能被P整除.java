package com.cks.exercise.algorithm;

public class 使数组和能被P整除 {

    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{3,1,4,2},6));
    }

    public static int minSubarray(int[] nums, int p) {
//        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % p == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((sum - nums[i]) % p == 0) {
                return i;
            }
        }

        
        return 0;
    }
}
