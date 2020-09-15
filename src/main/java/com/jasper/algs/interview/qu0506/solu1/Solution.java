package com.jasper.algs.interview.qu0506.solu1;

/**
 * 面试题 05.06. 整数转换
 * 
 * <p> 汉明重量
 */
class Solution {
    public int convertInteger(int A, int B) {
        int tmp = A ^ B, ans = 0;
        while(tmp!=0) {
            ans++;
            tmp &= (tmp-1);
        }
        return ans;
    }
}