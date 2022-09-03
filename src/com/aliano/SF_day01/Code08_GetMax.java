package com.aliano.SF_day01;

/**
 * Created by Intellij IDEA.
 *
 * @author Cure
 * @create 2022/9/3 14:48
 * 3.3
 */
public class Code08_GetMax {
    public static int getMax(int[] arr){
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R){
        if (L == R) {
            return arr[L];
        }

        // for (int i = L; i < R; i++) {
        //     System.out.println(arr[i]);
        // }

        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, mid + 1, R);
        int rightMax = process(arr, L, R);
        return Math.max(leftMax,rightMax);
    }
}
