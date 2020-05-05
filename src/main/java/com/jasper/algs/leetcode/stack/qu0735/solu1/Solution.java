package com.jasper.algs.leetcode.stack.qu0735.solu1;

import java.util.Stack;

/**
 * 0735. 行星碰撞
 *
 * <p> 辅助栈
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    	
    	// 边界
    	if(asteroids==null || asteroids.length<=1)
    		return asteroids;
    	
    	int N = asteroids.length;
    	
    	// 碰撞：正负相消
    	Stack<Integer> helper = new Stack<Integer>();
    	helper.push(0);// 哨兵
    	helper.push(asteroids[0]);
    	for (int i = 1; i < N;) {
    		// 跳过
    		if(asteroids[i]>0 // 正正：方向一致；负正：方向相背
    				|| helper.peek()<=0)//负负：方向一致；
    		{
    			helper.push(asteroids[i]);
    			i++;
    		} else {// 正负：相消
				int sum = helper.peek() + asteroids[i];
				if(sum<=0) helper.pop(); // 消去 helper.peek() 正
				if(sum>=0) i++;// 消去 asteroids[i] 负
			}
		}
    	
    	// 构造答案
    	N = helper.size() - 1;
    	int[] ans = new int[N];
		for (int i = N-1; i >= 0; i--) {
			ans[i] = helper.pop();
		}
		
		return ans;
    }
}