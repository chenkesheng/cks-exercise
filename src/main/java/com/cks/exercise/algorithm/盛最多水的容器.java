package com.cks.exercise.algorithm;

public class 盛最多水的容器 {

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        //左指针比右指针小的情况
        while (left < right) {
            //面积
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
