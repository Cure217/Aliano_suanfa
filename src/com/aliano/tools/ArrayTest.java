package com.aliano.tools;

import com.aliano.SF_day01.Code02_BubbleSort;

import java.util.Arrays;

import static com.aliano.SF_day01.Code01_SelectionSort.selectionSort;
import static com.aliano.SF_day01.Code02_BubbleSort.bubbleSort;
import static com.aliano.SF_day01.Code03_InsertionSort.insertionSort;
import static com.aliano.SF_day02.Code01_MergeSort.mergeSort;
import static com.aliano.SF_day02.Code06_QuickSort.quickSort;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/1 22:39
 */
public class ArrayTest {
    public static void testsort(int testTime, int maxSize, int maxValue){
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int [] arr1 = generateRandomArray(maxSize,maxValue);
            int [] arr2 = copyArray(arr1);
            // insertionSort(arr1);
            // comparetor(arr2);

            // bubbleSort(arr1);
            // comparetor(arr2);

            // selectionSort(arr1);
            // comparetor(arr2);

            // mergeSort(arr1);
            // comparetor(arr2);

            quickSort(arr1);
            comparetor(arr2);

            if (!isEqual(arr1,arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        // int[] arr = generateRandomArray(maxSize,maxValue);
        // printArray(arr);
        // insertionSort(arr);
        // printArray(arr);
    }

    // for test
    public static int[] copyArray(int[] arr){
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void comparetor(int [] arr){
        Arrays.sort(arr);
    }

    // for test 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {

        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * N -> [0,N) 所有的小数，等概率返回一个
        // (int)(Math.random() * N) -> [0,N - 1] 所有的整数，等概率返回一个

        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 长度随机

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
