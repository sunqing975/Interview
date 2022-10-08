package org.demo.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
        int target = 32;
        int idx = binarySearch(arr, target);
        System.out.println(idx);
        int i = binarySearchRecursion(arr, target, 0, arr.length - 1);
        System.out.println(i);
    }

    // 常规方式
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                return m;
            } else if (arr[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    // 递归
    public static int binarySearchRecursion(int[] arr, int target, int l, int r) {
        if (l > r) {
            return -1;
        }
        int m = (l + r) / 2;
        if (arr[m] == target) {
            return m;
        } else if (arr[m] > target) {
            r = m - 1;
        } else {
            l = m + 1;
        }
        return binarySearchRecursion(arr, target, l, r);
    }
}
