package org.demo.sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 9, 7, 8};
        insert(arr);
    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                continue;
            }
            int s = -1;
            int temp = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    s = j;
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[s] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
