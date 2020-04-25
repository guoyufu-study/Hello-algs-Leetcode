package com.jasper.algs.leetcode.bitmanipulation.qu0326.solu3;

/**
 * 换底公式
 */
class Solution {
    public boolean isPowerOfThree(int n) {
    	double epsilon = Math.ulp(1.0);
		return (Math.log10(n)/Math.log10(3) + epsilon) % 1 <= 2 * epsilon;
            
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double zero = 1.0/5.0 + 1.0/5.0 - 1.0/10.0 - 1.0/10.0 - 1.0/10.0 - 1.0/10.0;
        System.out.println("value is : " + zero);
        System.out.println("Double.compare with zero : " + Double.compare(zero, 0.0));
        System.out.println("isEqual with zero : " + isEqual(zero, 0.0));
    }

    public static boolean isEqual(double d0, double d1) {
        final double epsilon = 0.0000001;
        return d0 == d1 ? true : Math.abs(d0 - d1) < epsilon;
    }
}