package org.demo.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 9, 7, 8};
        int[] bubble = bubble(arr);
        System.out.println(Arrays.toString(bubble));
        int[] arr2 = {1, 5, 3, 2, 9, 7, 8};
        int[] bubble2 = bubble2(arr2);
        System.out.println(Arrays.toString(bubble2));
        int[] arr3 = {1, 5, 3, 2, 9, 7, 8};
        int[] bubble3 = bubble3(arr3);
        System.out.println(Arrays.toString(bubble3));
    }

    // 普通思路
    public static int[] bubble(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int j = 0; j < len - 1; j++) {
            for (int i = 0; i < len - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
                count++;
            }
        }
        System.out.println("共进行 " + count + " 次比较");
        return arr;
    }

    // 优化方式1
    public static int[] bubble2(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int j = 0; j < len - 1; j++) {
            // 用于判断一轮冒泡后，有没有发生交换
            // 如果没有发生交换，则表示数组有序
            boolean flag = false;
            for (int i = 0; i < len - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
                count++;
            }
            if (!flag) {
                break;
            }
        }
        System.out.println("共进行 " + count + " 次比较");
        return arr;
    }

    // 优化方式2
    public static int[] bubble3(int[] arr) {
        int n = arr.length-1;
        int count = 0;
        while (true) {
            // 每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数，
            // 如果这个值为零，表示整个数组有序，直接退出外层循环即可
            int last = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    last = i;
                }
                count++;
            }
            n = last;
            if (n == 0) {
                break;
            }
        }
        System.out.println("共进行 " + count + " 次比较");
        return arr;
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
