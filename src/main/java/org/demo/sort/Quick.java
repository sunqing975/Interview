package org.demo.sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 9, 7, 8};
        quick(arr, 0, arr.length - 1);
        int[] arr2 = {1, 5, 3, 2, 9, 7, 8};
        quick2(arr2, 0, arr2.length - 1);
    }

    // 单边
    private static void quick(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pv = arr[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (pv > arr[j]) {
                if (i != j) {
                    swap(arr, i, j);
                }
                i++;
            }
        }
        if (i != r) {
            swap(arr, i, r);
        }
        System.out.println("单："+Arrays.toString(arr));
        quick(arr, l, i - 1);
        quick(arr, i + 1, r);
    }

    // 双边
    private static void quick2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pv = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            // j 从右找小的（必须先找小的）
            while (i < j && arr[j] > pv) {
                j--;
            }
            // i 从左找大的
            while (i < j && arr[i] <= pv) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, l);
        System.out.println("双："+Arrays.toString(arr));
        quick2(arr, l, i - 1);
        quick2(arr, i + 1, r);
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
