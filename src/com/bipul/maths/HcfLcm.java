package com.bipul.maths;

public class HcfLcm {
    public static void main(String[] args) {
        int a = 4, b = 18;
        System.out.println("HCF: " + hcf(a,b));
        System.out.println("LCM: " + lcm(a,b));
    }

    private static int lcm(int a, int b) {
        return (a*b)/hcf(a,b);
    }

    private static int hcf(int a, int b) {
        if(a==0) return b;
        return hcf(b%a, a);
    }
}
