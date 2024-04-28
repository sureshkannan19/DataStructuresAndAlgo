package org.sk.math;


public class LCMAndGCD {

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    static int lcm(int a, int b, int gcdValue) {
        return Math.abs(a * b) / gcdValue;
    }

    public static void main(String[] args) {
        int a = 30, b = 20;
        int gcdValue = gcd(a, b);
        System.out.println("GCD = " + gcdValue);
        System.out.println("LCM = " + lcm(a, b, gcdValue));
    }
}
