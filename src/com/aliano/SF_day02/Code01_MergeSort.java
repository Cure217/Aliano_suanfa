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
 *
 * 左边有序 + 右边有序 在归并到一起
 */
public class Code01_MergeSort {
    public static void main(String[] args) {
        testsort(500000, 100, 100);
        // int [] array = {2,5,63,7,13,3,13};
        // mergeSort(array);
        // for (int i : array) {
        //     System.out.println(i);
        // }
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
        int[] help = new int[R - L + 1]; // 辅助空间
        int i = 0; // help数组的下标
        // 双指针 第一个区域是L - M 第二个区域是 M + 1 - R
        int p1 = L; // 左侧部分首位置的下标
        int p2 = M + 1; // 右侧部分首位置的下标
        while (p1 <= M && p2 <= R) { // 比较左右部分 对应下标 谁的值小  小的进辅助空间 进了的指针下标加一
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; // 两个之相等时 先将右边的值拷贝下去
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
