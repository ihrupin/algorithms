package com.hrupin.algorithms.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] unsortedArray = new int[] {9, 1, 5, 6, 7, 4, 2, 1, 7, 8, 0};
        System.out.println("Before sorting=" + Arrays.toString(unsortedArray));

        int[] sortedArray = sort(unsortedArray);

        System.out.println("After sorting=" + Arrays.toString(sortedArray));
    }

    public static int[] sort(int[] array) {
        qsort(array, 0, array.length - 1);
        return array;
    }

    public static void qsort(int[] array, int leftIndex, int rightIndex) {
        int l = leftIndex;
        int r = rightIndex;
        int pivot = array[(leftIndex + rightIndex) >> 1];
        while (l <= r) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[r] > pivot) {
                r--;
            }
            if (l <= r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        if (leftIndex < r){
            qsort(array, leftIndex, r);
        }
        if(l < rightIndex){
            qsort(array, l, rightIndex);
        }
    }
}
