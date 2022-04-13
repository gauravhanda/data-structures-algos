package com.learning.palidrome;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class SimplePalindrome {
    public static void main(String[] args) {
        String s = "";
        String str = "({[()]}()[])";
        System.out.println(str);

        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        if (str.length() % 2 != 0 || str.length() == 0) {
            return false;
        }

        String regex = "\\{\\}|\\(\\)|\\[\\]";
        int oldLength = str.length();
        int newLength = 0;
        while(newLength - oldLength !=0) {
            oldLength = str.length();
            str = str.replaceAll(regex, "");
            newLength = str.length();
        }



        return true;

}

    public static boolean validPalindrome(Integer[] s) {
        int rIndex = s.length - 1;
        int lIndex = 0;
        while (lIndex <= rIndex) {
            if (s[lIndex] != s[rIndex]) {
                return false;
            }
            lIndex++;
            rIndex--;
        }
        return true;
    }
}

