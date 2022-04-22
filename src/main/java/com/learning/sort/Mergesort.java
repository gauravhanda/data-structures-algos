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
    public static int[] divide(int array[], int low, int high) {
        if (high > 0) { // As we fixed the low to always zero, high is the only factor to be considered
            int mid = high / 2; // Finding mid-point as integer, can be even or odd.
            // Last parameter of Array.copyOfRange is one more than end index.
            int[] lArray = Arrays.copyOfRange(array, low, mid + 1); // Copying to left Array from 0 to mid
            int[] rArray = Arrays.copyOfRange(array, mid + 1, high + 1); // Copying right array from mid+1 to high
            lArray = divide(lArray, 0, lArray.length - 1); // recursive operation on left small array.
            rArray = divide(rArray, 0, rArray.length - 1); // recursive operation on right array
            array = merge(array, lArray, rArray); // merging the arrays
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
    public static int[] merge(int sortedArray[], int[] lArray, int[] rArray) {
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

        return sortedArray;
    }

    public static void main(String[] args) {
        int array[] = IntStream.range(0, 10).unordered().toArray();
        array = divide(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
