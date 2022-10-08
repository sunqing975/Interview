package org.demo.sort;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {1, 5, 3, 2, 9, 7, 8, 6};
        //增量
        int gap = arr.length;
        //排序
        shell(arr, gap);
        System.out.println(Arrays.toString(arr));
    }

    public static void shell(int[] arr, int gap) {
        //确定新一轮分组的增量
        gap = gap / 2;
        //对数组进行分组
        for (int i = 0; i < gap; i++) {
            for (int j = i + gap; j < arr.length; j += gap) {
                //获取当前元素，然后在本组内部向前比较并排序
                int current = arr[j];
                for (int k = j - gap; k >= i; k -= gap) {
                    if (arr[k] > current) {
                        //插入
                        arr[k + gap] = arr[k];
                        arr[k] = current;
                    }
                }
            }
        }
        if (gap > 1) {
            shell(arr, gap);
        }
    }
}
