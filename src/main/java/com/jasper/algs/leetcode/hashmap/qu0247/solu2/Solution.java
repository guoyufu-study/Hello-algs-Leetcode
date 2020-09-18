package com.jasper.algs.leetcode.hashmap.qu0247.solu2;

import java.util.ArrayList;
import java.util.List;

/**
 * 0247. 中心对称数 II
 * 
 * <p> 左右步进
 */
class Solution {
    
    List<String> ans;
    int mid, n;
    char[] odd = new char[] {'0', '1', '8'};
    char[] lefts = new char[] {'0', '1', '6', '8', '9'};
    char[] rights = new char[] {'0', '1', '9', '8', '6'};
    public List<String> findStrobogrammatic(int n) {
        ans = new ArrayList<>();

        // 左右进步
        char[] memo = new char[n];
        this.n = n;
        mid = n/2;
        int left = 0, right = n-1;
        extend(left, right, memo);
        
        return ans;
    }

    void extend(int left, int right, char[] memo) {
        if(left==mid) {
            if(memo[0]=='0') return ;
            // 添加非 0 开头的答案
            if((n & 1) == 1) {// 奇数
                for(char c : odd) {
                    memo[mid] = c;
                    ans.add(new String(memo));
                }
            } else // 偶数
                ans.add(new String(memo));

            return ;
        }
        
        // 递归扩展
        for(int i=0; i<5; i++) {
            memo[left] = lefts[i];
            memo[right] = rights[i];
            extend(left+1, right-1, memo);
        }
    }
}