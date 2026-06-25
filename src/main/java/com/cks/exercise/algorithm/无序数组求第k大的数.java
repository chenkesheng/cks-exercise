package com.cks.exercise.algorithm;

import java.util.Arrays;

public class 无序数组求第k大的数 {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 7, 2, 23, 15, 18, 21, 14, 11, 6, 3, 9};
        System.out.println(Arrays.toString(Arrays.stream(smallLeastK(arr, 6)).toArray()));
    }

    public static int[] smallLeastK(int[] arr, int k) {
        int len = arr.length;
        if (k >= len) {
            return arr;
        }
        if (k == 0) {
            return new int[0];
        }
        buildMinHeap(arr, len);
        int pos = len - k;
        for (int i = len - 1; i >= pos; i--) {
            swap(arr, 0, i);
            heapFy(arr, 0, i);
        }
        int[] re = new int[k];
        int j = 0;
        for (int i = len - 1; i >= pos; i--) {
            re[j++] = arr[i];
        }
        return re;
    }

    private static void buildMinHeap(int[] arr, int length) {
        for (int i = (length - 1) / 2; i >= 0; i--) {
            heapFy(arr, i, length);
        }
    }

    private static void heapFy(int[] arr, int i, int len) {
        if (i >= len) {
            return;
        }
        int min = i;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        if (c1 < len && arr[c1] < arr[min]) {
            min = c1;
        }
        if (c2 < len && arr[c2] < arr[min]) {
            min = c2;
        }
        if (min != i) {
            swap(arr, 0, i);
            heapFy(arr, 0, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
