package com.data.structure.basic;

/**
 * Created by admin on 2018/10/7.
 */

import java.util.Scanner;

/**
 * 求两段子序列的和  Poj 2479
 *
 *
 */
public class MaximumSum {

    public static void main(String[] args) {
        int[] a = new int[50000];
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while(t > 0){
            t --;
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(findMaximumSum(a, n));
        }
    }

    private static int findMaximumSum(int[] a, int n) {
        int[] dpl = new int[n];
        int[] dpr = new int[n];
        int sum = 0, max = -30000, maxSum = -30000;
        for (int i = 0 ; i < n; i++){
            sum += a[i];
            if (maxSum < sum){
                maxSum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
            dpl[i] = maxSum;
        }
        sum = 0; maxSum = -30000;
        for (int i = n - 1; i >= 0; i--){
            sum += a[i];
            if (maxSum < sum){
                maxSum = sum;
            }
            if (sum < 0){
                sum = 0;
            }
            dpr[i] = maxSum;
        }

        for (int i = 0; i < n - 1; i++){
            if (max < dpl[i] + dpr[i+1]){
                max = dpl[i] + dpr[i+1];
            }
        }
        return max;
    }
}
