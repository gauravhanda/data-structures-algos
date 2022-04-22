package com.learning.array;

import java.util.Arrays;

public class BitArray {
    public int maxContinuous1sInBitArray(int[] array) {
        int maxCount = 0, total = 0;

        for (int num : array) {
            if (num == 1) {
                total++;
            } else {
                maxCount = Math.max(maxCount, total);
                System.out.println(maxCount);
                total = 0;
            }
        }
        return Math.max(maxCount, total);
    }

    public int countDigitsInNumber(int num) {
        int digit = 1;
        while (num / 10 > 0) {
            digit++;
            num = num / 10;
        }

        return digit;
    }

    public int[] sortSquareArray(int[] num) {
        for (int i = 0; i < num.length; i++) {
            num[i] = num[i] * num[i];
        }
        Arrays.sort(num);
        return num;
    }

    public static void main(String[] args) {
        BitArray bitArray = new BitArray();
        int[] array = new int[]{12, 345, 2, 6, 7896};

        int evenDigitNum = 0;
        for (int num : array) {
            if (bitArray.countDigitsInNumber(num) % 2 == 0) {
                evenDigitNum++;
            }
        }

        System.out.println("Even Digit numbers " + evenDigitNum);
    }
}
