package org.sk.bitmanipulation;

public class NumberOfOneBit {

    public int hammingWeight(int n) {
        int result = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                result++;
            }
            n /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfOneBit nob = new NumberOfOneBit();
        System.out.println(nob.hammingWeight(11));
        System.out.println(nob.hammingWeight(128));
    }
}
