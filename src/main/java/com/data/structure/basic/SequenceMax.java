package com.data.structure.basic;

import java.util.Scanner;

/**
 * Created by admin on 2018/10/6
 *
 * 最大连续子序列 hdu1231
 * 利用递归分治的思想求值
 */
public class SequenceMax {

    static class Item{
        int start, end;
        public Item(int s, int e){
            start = s;
            end = e;
        }
        public Item(){

        }
    }
    public static void main(String[] args) {

        int[] a = new int[10000];
        Scanner scanner = new Scanner(System.in);
        int n = 1;
        while(n > 0){
            n = scanner.nextInt();
            if ( n == 0){
                break;
            }
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            Item targetItem = new Item(a[0], a[n - 1]);
            int seqMax = findSeqMax(a, 0, n - 1, targetItem);
            if (seqMax < 0 ){
                seqMax = 0;
            }
            System.out.println(seqMax+ " " + targetItem.start + " " +targetItem.end);
        }
    }

    private static int findSeqMax(int[] a, int start, int end, Item item) {
        if (start == end){
            return a[start] <  -1 ? -1 : a[start];
        }
        int mid = (start + end) / 2;
        Item leftItem = new Item(a[start], a[mid]);
        int left = findSeqMax(a, start, mid, leftItem);
        Item rightItem = new Item(a[mid + 1], a[end]);
        int right = findSeqMax(a, mid + 1, end, rightItem);
        Item midItem = new Item();
        int midSum = sumSeqMax(a, start, mid, end, midItem);
        assignValue(item, leftItem, left, rightItem, right, midItem, midSum);
        int max = Math.max(Math.max(left, right), midSum);
        return max;
    }

    private static void assignValue(Item item, Item leftItem, int left, Item rightItem, int right, Item midItem, int midSum) {
        if (left >=0 && left >= right){
            if (left >= midSum){
                setItem(item, leftItem);
            }else {
                setItem(item, midItem);
            }
        }else if (right >=0 && right >= left){
            if (midSum >= right){
                setItem(item, midItem);
            }else {
                setItem(item, rightItem);
            }
        }else if (midSum >= 0){
            setItem(item, midItem);
        }
    }

    private static void setItem(Item endItem, Item startItem) {
        endItem.start = startItem.start;
        endItem.end = startItem.end;
    }


    private static int sumSeqMax(int[] a, int start, int mid, int end, Item item) {
        int sum = 0;
        int max = -1;
        for (int i = mid; i >= start; i--){
            sum += a[i];
            if (max < sum){
                max = sum;
                item.start = a[i];
            }
        }
        sum = max;
        for (int i = mid + 1; i <= end; i++){
            sum += a[i];
            if (max < sum){
                max = sum;
                item.end = a[i];
            }
        }
        return max;
    }
}
