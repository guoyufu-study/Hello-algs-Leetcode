package com.jasper.algs.leetcode.qu0007.solu3;

/**
 * 负数转正数
 */
public class Solution {

	public int reverse(int x) {
        if(x==Integer.MIN_VALUE) return 0;//最小值
		if(x<0) return -reverse(-x); //负数
		
		int ans = 0;
		while(x!=0) {//正数
			if(ans>Integer.MAX_VALUE/10) return 0;
			ans = ans*10+x%10;
			x/=10;
		}
		
		return ans;
    }
}
