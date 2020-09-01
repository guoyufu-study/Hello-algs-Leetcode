package com.jasper.algs.leetcode.binarysearch.qu0374.solu1;

import com.jasper.algs.leetcode.binarysearch.qu0374.GuessGame;

/**
 * 0374. 猜数字大小
 * 
 * <p> 二分查找
 */
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < right) {
        	int mid = left + (right - left) / 2;
        	int res = guess(mid);
        	if(res==-1) right = mid - 1;
        	else if(res == 1) left = mid + 1;
        	else return mid;
        }
    	return left;
    }
}