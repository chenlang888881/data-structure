package com.data.structure.basic;

import java.util.Scanner;

/**
 * Created by admin on 2018/10/7.
 *
 *
 */
public class SequenceMaxMethod2 {

    public static void main(String[] args) {
        int[] a = new int[10000];
        Scanner scanner = new Scanner(System.in);
        int n = 1;
        while(n > 0) {
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(findSequenceMax(a, n));
        }
    }

    private static int findSequenceMax(int[] a, int n) {
        int max = 0, sum = 0;
        for (int i = 0; i < n; i++){
            sum += a[i];
            if (max < sum){
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
