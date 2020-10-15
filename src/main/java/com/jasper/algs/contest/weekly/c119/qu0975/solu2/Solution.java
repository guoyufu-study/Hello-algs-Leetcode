package com.jasper.algs.contest.weekly.c119.qu0975.solu2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 0975. 奇偶跳
 * 
 * <p> 排序 + 单调栈 + 动态规划
 */
class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        
        // 跳跃目标索引：单调栈
        Integer[] B = new Integer[n];
        for (int i = 0; i < n; i++) B[i] = i;
        Arrays.sort(B, (a, b) -> A[a] == A[b] ? a - b : A[a] - A[b]); // 奇次跳
        int[] oddnext = make(B);
        Arrays.sort(B, (a, b) -> A[a] == A[b] ? a - b : A[b] - A[a]); // 偶次跳
        int[] evennext = make(B);
        
        // 终点可达：动态规划
        boolean[][] dp = new boolean[n][2];
        dp[n - 1][0] =  dp[n - 1][1] = true;
        for (int i = n - 2; i >= 0; i--){
        	if (oddnext[i]>0 && dp[oddnext[i]][1]) dp[i][0] = true; 
            if (evennext[i]>0 && dp[evennext[i]][0]) dp[i][1] = true;
        }
        
        // 统计
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (dp[i][0]) ans++;
        }
        return ans;
    }
    
    int[] make(Integer[] B){
        int[] ans = new int[B.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(B[0]);
        for (int i = 1; i < B.length; i++){
            while(!stack.isEmpty() && stack.peek() < B[i]){
                ans[stack.pop()] = B[i];
            }
            stack.push(B[i]);
        }
        return ans;
    }
}