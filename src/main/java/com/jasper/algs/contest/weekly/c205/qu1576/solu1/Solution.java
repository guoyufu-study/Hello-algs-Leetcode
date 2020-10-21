package com.jasper.algs.contest.weekly.c205.qu1576.solu1;

/**
 * 1576. 替换所有的问号
 * 
 * <p> 检测替换
 */
class Solution {
    public String modifyString(String s) {
        char[] abc = "abc".toCharArray();
        char[] sc = s.toCharArray();
        int n = sc.length;
        for(int i=0; i<n; i++) {
            if(sc[i]=='?') {
                for(char c : abc) {
                	if(c!=(i==0 ? 'A' : sc[i-1]) &&
                			c!=(i==n-1 ? 'A' : sc[i+1]))
                		sc[i] = c;
                }
            }
        }
        return new String(sc);
    }
}