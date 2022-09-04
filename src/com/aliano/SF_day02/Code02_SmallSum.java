package com.aliano.SF_day02;

import static com.aliano.util.ArrayTest.testsort;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/3 16:35
 *
 * 3.3
 * 小和问题
 */
public class Code02_SmallSum {
    public static void main(String[] args) {
        // testsort(500000, 100, 100);
        int [] array = {2,5,63,7,13,3,13};
        smallSum(array);
    }

    public static void smallSum(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        System.out.println(process(arr, 0, arr.length - 1));

    }

    public static int process(int[] arr, int l, int r){
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int L, int m, int r){
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0; // 先取右边区间个数
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; // 两个值相等时 先将右边的值拷贝下去
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}
