package com.jasper.algs.leetcode.string.qu0657.solu1;

/**
 * 0657. 机器人能否返回原点
 * 
 * <p> 计数相消
 */
class Solution {
    public boolean judgeCircle(String moves) {
    	int n = moves.length();
    	if(n%2==1) return false;
    	
    	int x = 0, y = 0;
    	for (char c : moves.toCharArray()) {
			switch (c) {
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			}
		}
    	
    	return x==0 && y==0;
    }
}