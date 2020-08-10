package com.jasper.algs.interview.qu0101.solu1;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 
 * <p>辅助字典
 */
class Solution {
    public boolean isUnique(String astr) {
        int n = astr.length();
        
        boolean[] arr = new boolean[26];

        // 暴力枚举
        for(int i=0; i<n; i++) {
            if(arr[astr.charAt(i)-'a'])
            	return false;
            arr[astr.charAt(i)-'a'] = true;
        }

        return true;
    }
}