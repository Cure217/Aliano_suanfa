package com.aliano.SF_day01;

import static com.aliano.tools.ArrayTest.testsort;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/1 19:56
 *
 * 2.2
 * 选择排序的实现
 * 从0 - N-1 选出 最小的放到第一位
 * 从1 - N-1 选出 最小的放到第二位
 * 直到最后一位
 * O(n²)
 */
public class Code01_SelectionSort {
    public static void main(String[] args) {
        // int [] array = {2,5,63,7,6,89};
        // selectionSort(array);
        // for (int i : array) {
        //     System.out.println(i);
        // }
        testsort(500000,100,100);
    }

    public static void selectionSort(int [] arr){
        if (arr ==null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
             int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int [] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
