package com.aliano.SF_day01;

import java.util.Arrays;

import static com.aliano.tools.ArrayTest.testsort;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/1 21:07
 *
 * 2.2
 * 插入排序
 */
public class Code03_InsertionSort {
    public static void main(String[] args) {
        // int [] array = {2,5,63,7,6,89,46,6451,613,13,138,13,3,13};
        // insertionSort(array);
        // for (int i : array) {
        //     System.out.println(i);
        // }
        testsort(500000,100,100);

    }



    // i和j是一个位置的话，会出错
    public static void swap(int [] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void insertionSort(int [] arr){
        if (arr ==null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }


}
