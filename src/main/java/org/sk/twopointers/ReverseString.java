package org.sk.twopointers;

import java.util.Arrays;

public class ReverseString {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        char temp = ' ';
        while(left <= right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new char[] {'o','l','l','e','h'}));
    }
}
