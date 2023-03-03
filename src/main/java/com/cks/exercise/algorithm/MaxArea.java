package com.cks.exercise.algorithm;

/**
 * @Author: cks
 * @Date: Created by 下午2:27 2021/7/30
 * @Package: com.cks.exercise.algorithm
 * @Description:
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        System.out.println(maxarea);
        return maxarea;
    }

    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(h);
    }
}
