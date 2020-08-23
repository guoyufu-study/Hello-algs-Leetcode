package com.jasper.algs.contest.weekly.c139.qu1071.solu3;

/**
 * 1071. 字符串的最大公因子
 * 
 * <p> 数学：辗转相除
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) 
            return "";
        
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
}