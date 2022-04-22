package com.learning.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Mergesort {
    /**
     * Indexes in this implementation are 0 based, to avoid any adjustment while lookup array.
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static int[] divide(int array[]) {
        if (array.length > 1) { // As we fixed the low to always zero, high is the only factor to be considered
            int mid = (array.length - 1) / 2; // Finding mid-point as integer, can be even or odd.
            // Last parameter of Array.copyOfRange is one more than end index.
            int[] lArray = Arrays.copyOfRange(array, 0, mid + 1); // Copying to left Array from 0 to mid
            int[] rArray = Arrays.copyOfRange(array, mid + 1, array.length); // Copying right array from mid+1 to high
            lArray = divide(lArray); // recursive operation on left small array.
            rArray = divide(rArray); // recursive operation on right array
            merge(array, lArray, rArray); // merging the arrays
        }
        return array;
    }

    /**
     * Standard merge operation
     *
     * @param sortedArray
     * @param lArray
     * @param rArray
     * @return
     */
    public static void merge(int sortedArray[], int[] lArray, int[] rArray) {
        int lIndex = 0, rIndex = 0, sortedArrayIndex = 0;

        // Till one the array ends as the arrays can be of different size.
        while (lIndex < lArray.length && rIndex < rArray.length) {
            sortedArray[sortedArrayIndex++] = lArray[lIndex] >= rArray[rIndex] ? rArray[rIndex++] : lArray[lIndex++];
        }

        // Pending elements in array can be blindly copied from lArray
        while (lIndex < lArray.length) {
            sortedArray[sortedArrayIndex++] = lArray[lIndex++];
        }

        // Pending elements in array can be blindly copied from lArray
        while (rIndex < rArray.length) {
            sortedArray[sortedArrayIndex++] = rArray[rIndex++];
        }
    }

    public static void main(String[] args) {
        int array[] = new int[]{10,6,8,5,7,3,4};
        array = divide(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
