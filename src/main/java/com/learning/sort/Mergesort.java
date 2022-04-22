package com.learning.sort;

import java.util.Arrays;

public class Mergesort {
    public static int[] divide(int array[], int low, int high) {
        if (low != high) {
            int mid = (high + low) / 2;
            int[] lArray = Arrays.copyOfRange(array, low, mid + 1);
            int[] rArray = Arrays.copyOfRange(array, mid + 1, high + 1);
            lArray = divide(lArray, 0, mid);
            rArray = divide(rArray, 0, high-(mid+1));
            array = merge(array, lArray, rArray);
        }
        return array;
    }

    public static int[] merge(int sortedArray[], int[] lArray, int[] rArray) {
        int lIndex = 0, rIndex = 0;
        int sortedArrayIndex = 0;

        while (lIndex < lArray.length && rIndex < rArray.length) {
            if (lArray[lIndex] >= rArray[rIndex]) {
                sortedArray[sortedArrayIndex++] = rArray[rIndex++];
            } else {
                sortedArray[sortedArrayIndex++] = lArray[lIndex++];
            }
        }

        for (; lIndex < lArray.length; lIndex++) {
            sortedArray[sortedArrayIndex++] = lArray[lIndex];
        }
        for (; rIndex < rArray.length; rIndex++) {
            sortedArray[sortedArrayIndex++] = rArray[rIndex];
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        int array[] = {5,4,3,2};
        array = divide(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
