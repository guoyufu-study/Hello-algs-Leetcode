package com.jasper.algs.leetcode.backtracing.qu1345.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1345. 跳跃游戏 IV
 * 
 * <p> BFS
 */
class Solution {
    public int minJumps(int[] arr) {

    	int length = arr.length;
    	
    	// 字典优化同值查找
    	Map<Integer,List<Integer>> map = new HashMap<>();
    	for (int i = 0; i < length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], new LinkedList<Integer>());
			}
			map.get(arr[i]).add(i);
		}
    	
    	// BFS 队列
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.offer(0);
    	// 标记已经过
    	boolean[] used = new boolean[arr.length];
    	used[0] = true;
    	
    	// 结果
    	int ans = -1;
    	
    	outer :
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		
    		ans++;
    		
    		for (int i = 0; i < size; i++) {
    			// 出队
				int poll = queue.poll();
				
				// 终止
				if(poll+1==length) {
					break outer; 
				}
				
				// 同值
				List<Integer> list = map.get(arr[poll]);
				map.put(arr[poll], new ArrayList<Integer>());// 防止超时
				for (int index : list) {
					if(used[index]) continue;
					used[index] = true;
					queue.add(index);
				}
				// 左1
				int left = poll-1;
				if(left>=0 && !used[left]) {
					used[left] = true;
					queue.offer(left);
				}
				
				// 右1
				int right = poll+1;
				if(right<length && !used[right]) {
					used[right] = true;
					queue.offer(right);
				}
				
			}
    	}
    	return ans;
    }

	public static void main(String[] args) {
		
		// 3
//		int[] arr = new int[] {100,-23,-23,404,100,23,23,23,3,404};
		
		// 0
//		int[] arr = new int[] {7};
		
		
		// 1
//		int[] arr = new int[] {7,6,9,6,9,6,9,7};
		
		// 2
//		int[] arr = new int[] {6,1,9};
		
		// 3
//		int[] arr = new int[] {11,22,7,7,7,7,7,7,7,22,13};
		
		// 5
		int[] arr = new int[] {-76,3,66,-32,64,2,-19,-8,-5,-93,80,-5,-76,-78,64,2,16};

		System.out.println(new Solution().minJumps(arr));
	}
}