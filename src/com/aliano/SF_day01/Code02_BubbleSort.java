package com.aliano.SF_day01;

import static com.aliano.tools.ArrayTest.testsort;

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
        // int [] array = {2,5,63,7,6,89,46,6451,613,13,138,13,3,13};
        // bubbleSort(array);
        // for (int i : array) {
        //     System.out.println(i);
        // }
        testsort(500000,100,100);
    }

    public static void swap(int [] arr, int i, int j){
        /**
         * 异或运算
         * 相同为0 不相同为1 也可以理解为无进位相加
         *
         * 性质：
         * 1) 0 ^ N = N , N ^ N = 0
         * 2）满足交换律，结合律 即同一批数运算与顺序无关 偶数次出现的数是0 奇数次是1
         *
         * 但是在这里必须保证a和b 分别指向不同的内存 即i的位置不等于j的位置
         */

        // 利用异或运算不需要增加新的临时变量 即不需要额外的空间
        arr[i] = arr[i] ^ arr[j]; // a = 甲 ^ 乙; b = 乙
        arr[j] = arr[i] ^ arr[j]; // a = 甲 ^ 乙; b = 甲 ^ 乙 ^ 乙 = 甲
        arr[i] = arr[i] ^ arr[j]; // a = 甲 ^ 乙 ^ 甲 = 乙; b = 甲
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
