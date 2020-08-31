package com.jasper.algs.contest.weekly.c169.qu1306.solu1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1306. 跳跃游戏 III
 * 
 * <p> BFS
 */
class Solution {
	
    public boolean canReach(int[] arr, int start) {
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.offer(start);
    	
    	// 使用数组，而不使用HashSet：更快
    	int length = arr.length;
		boolean[] used = new boolean[length];
    	used[start] = true;
		
    	while(!queue.isEmpty()) {
    		int poll = queue.poll();
    		
    		// 找到 0
    		if(arr[poll]==0) 
    			return true;
    		
    		// 向左
    		int left = poll-arr[poll];
    		if(left>=0 && !used[left]) {// 剪枝
    			queue.offer(left);
    			used[left]=true;
    		}
    		
    		// 向右
    		int right = poll+arr[poll];
    		if(right<length && !used[right]) {// 剪枝
    			queue.offer(right);
    			used[right]=true;
    		}
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	// true
//		int[] arr = new int[] {4,2,3,0,3,1,2};
//		int start = 5;
		
		// true
//		int[] arr = new int[] {4,2,3,0,3,1,2};
//		int start = 0;
		
		// false
//		int[] arr = new int[] {3,0,2,1,2};
//		int start = 0;
		
		// true 
		int[] arr = new int[] {0,1}; // left>=0
		int start = 1; 
		
		System.out.println(new Solution().canReach(arr, start));
	}
}