package com.cks.exercise;

import java.util.Scanner;

/**
 * @Author: cks
 * @Date: Created by 9:58 2018/8/28
 * @Package: com.cks.exercise
 * @Description:
 */
public class RemoveArray {

    static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};


    public static int[] delete(int index, int array[]) {
        //数组的删除其实就是覆盖前一位
        int[] arrNew = new int[array.length - 1];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        System.arraycopy(array, 0, arrNew, 0, arrNew.length);
        return arrNew;
    }

    public static void main(String[] args) {
        int [] a = delete(3,array);
        for (int i = 0;i< a.length;i++){
            System.out.println(a[i] + " ");
            System.exit(0);
        }

    }
}
