package com.aliano.SF_day02;

import static com.aliano.util.ArrayTest.testsort;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/3 15:38
 *
 * 归并排序 3.3
 * 利用递归
 */
public class Code01_MergeSort {
    public static void main(String[] args) {
        testsort(500000, 100, 100);
    }

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R){
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
