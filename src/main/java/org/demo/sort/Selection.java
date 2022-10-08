package org.demo.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 9, 7, 8};
        selection(arr);
    }

    public static void selection(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n+1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i){
                swap(arr, i, min);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
