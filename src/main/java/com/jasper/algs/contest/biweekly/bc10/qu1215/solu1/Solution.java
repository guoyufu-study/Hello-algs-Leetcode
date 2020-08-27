package com.jasper.algs.contest.biweekly.bc10.qu1215.solu1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1215. 步进数
 * 
 * <p> BFS
 */
class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
    	List<Integer> ans = new ArrayList<>();
    	// 0
        if(low==0) ans.add(0);

        // 1~9
        Deque<Integer> queue = new LinkedList<Integer>();
        for(int i=1; i<=9 && i<=high; i++) {
            queue.offer(i);
            if(i>=low)
                ans.add(i);
        }

        // >=10
        while(!queue.isEmpty()) {
            int prev = queue.poll();
            int end = prev % 10;
            // 较小值
            if(end!=0) {
                int num = prev * 10 + (end -1);
                if(num>high) return ans;
                if(num>=low) ans.add(num);
                queue.offer(num);
            }
            // 较大值
            if(end!=9) {
                int num = prev * 10 + (end + 1);
                if(num>high) return ans;
                if(num>=low) ans.add(num);
                queue.offer(num);
            }
        }

        return ans;
    }
}