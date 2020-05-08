package com.jasper.algs.leetcode.greedy.qu0649;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0649. Dota2 参议院
 * 
 * <p> 模拟过程
 */
class Solution {
    public String predictPartyVictory(String senate) {
    	Queue<Integer> queue = new LinkedList<>();// 缓存剩余参议员
        int[] people = new int[]{0, 0};// 计数参议员
        int[] bans = new int[]{0, 0};// 计数禁令
        
        // 初始构造
        for (char person : senate.toCharArray()) {
			int x = person=='R' ? 1 : 0; // D => 0、R => 1
			people[x]++;
			queue.add(x);
		}
    	
    	// 模拟过程
        while(people[0]>0 && people[1]>0) {
        	int x = queue.poll();
        	if(bans[x] > 0) {
        		bans[x]--; // 消耗一枚禁令
        		people[x]--; // 禁止一名参议员
        	} else {
        		bans[x^1]++; // 增加一枚禁令
        		queue.add(x); // 重新缓存一名参议名
        	}
        }
    	
        return people[0] > 0 ? "Dire" : "Radiant";
    }
}