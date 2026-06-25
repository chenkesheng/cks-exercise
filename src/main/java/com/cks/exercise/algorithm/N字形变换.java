package com.cks.exercise.algorithm;

public class N字形变换 {

    public static void main(String[] args) {
       String s = "AB";
       int numRows = 1;
        System.out.println(     convert(s,numRows));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        StringBuffer[] builders = new StringBuffer[numRows];

        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuffer();
        }
        int index = 0;
        int row = 0;
        int length = s.length();
        while (index < length) {
            while (index < length && row < numRows) {
                char ch = s.charAt(index++);
                builders[row].append(ch);
                row++;
            }
            if (index == length) {
                break;
            }
            row = row - 2;
            while (index < length && row >= 0) {
                char ch = s.charAt(index++);
                builders[row].append(ch);
                row--;
            }
            row += 2;
        }
        StringBuilder data = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            data.append(builders[j]);
        }
        return data.toString();
    }
}
