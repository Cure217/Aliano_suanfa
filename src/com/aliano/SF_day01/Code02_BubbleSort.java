package com.aliano.SF_day01;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/1 20:11
 *
 * 冒泡排序的实现
 * 0 - N-1 前后两个一次作比较 小的在前大的在后 选出最大的在第N个
 * 0 - N-2 前后两个一次作比较 小的在前大的在后 选出最大的在第N-1个
 * O(n²)
 */
public class Code02_BubbleSort {
    public static void main(String[] args) {
        int [] array = {2,5,63,7,6,89,46,6451,613,13,138,13,3,13};
        bubbleSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void swap(int [] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void bubbleSort(int [] arr){
        if (arr ==null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0 ; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }
}
