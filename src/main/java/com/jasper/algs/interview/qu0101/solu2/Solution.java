package com.jasper.algs.interview.qu0101.solu2;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 
 * <p>抽屉原理 + 暴力枚举
 */
class Solution {
    public boolean isUnique(String astr) {
        int n = astr.length();
        
        // 抽屉原理
        if(n>26) 
            return false;

        // 暴力枚举
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(astr.charAt(i)==astr.charAt(j))
                    return false;
            }
        }

        return true;
    }
}