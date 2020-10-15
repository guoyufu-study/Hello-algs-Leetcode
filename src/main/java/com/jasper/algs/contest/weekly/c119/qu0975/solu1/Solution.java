package com.jasper.algs.contest.weekly.c119.qu0975.solu1;

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
        
        // 下一步索引：单调栈
        int[][] sorted = new int[n][2];
        fill(sorted, A);// 奇数次
        Arrays.sort(sorted, (a, b) -> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        int[] oddnext = make(sorted);
        fill(sorted, A);// 偶数次
        Arrays.sort(sorted, (a, b) -> a[1]==b[1] ? a[0]-b[0] : b[1]-a[1]);
        int[] evennext = make(sorted);

        // 可达终点：DP
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = even[n-1] = true;
        for(int i=n-2; i>=0; i--) {
            if(oddnext[i]>0) odd[i] = even[oddnext[i]];
            if(evennext[i]>0) even[i] = odd[evennext[i]];
        }
        
        // 统计
        int ans = 0;
        for(boolean yesorno : odd) 
            if(yesorno) ++ans;
        return ans;
    }

    void fill(int[][] T, int[] A) {

        for(int i=0; i<A.length; i++) {
            T[i][0] = i;
            T[i][1] = A[i];
        }
    }

    int[] make(int[][] sorted) {
        int n = sorted.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && sorted[i][0]>stack.peek())
                ans[stack.pop()] = sorted[i][0];
            stack.push(sorted[i][0]);
        }
        return ans;
    }
}