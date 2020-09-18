package com.jasper.algs.leetcode.hashmap.qu0247.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0247. 中心对称数 II
 * 
 * <p> 中心扩展
 */
class Solution {
    
    List<String> ans;
    char[] odd = new char[] {'0', '1', '8'};
    char[] lefts = new char[] {'0', '1', '6', '8', '9'};
    char[] rights = new char[] {'0', '1', '9', '8', '6'};
    public List<String> findStrobogrammatic(int n) {
        ans = new ArrayList<>();
        
        // 中心扩展：确定中心字符并扩展
        char[] memo = new char[n];
        int mid = n/2;
        if((n & 1) == 0) { // 偶数
            extend(mid-1, mid, memo);
        } else { // 奇数
            for(char c : odd) {
                memo[mid] = c;
                extend(mid-1, mid+1, memo);
            }
        }
        
        if(n==1) ans.add("0");
        return ans;

    }

    void extend(int left, int right, char[] memo) {
        if(left<0) {
            if(memo[0]!='0') // 添加非 0 开头的答案
                ans.add(new String(memo));
            return ;
        }
        
        // 递归扩展
        for(int i=0; i<5; i++) {
            memo[left] = lefts[i];
            memo[right] = rights[i];
            extend(left-1, right+1, memo);
        }
        
    }
}