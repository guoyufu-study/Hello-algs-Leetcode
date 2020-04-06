package com.jasper.algs.leetcode.maths.qu0233.solu1;

/**
 * 暴力求解：双层遍历
 */
public class Solution {

	public int countDigitOne(int n) {

		int ans=0;
		for (int i = 0; i <= n; i++) {//暴力求解：双层遍历
			int tmp=i;
			while(tmp!=0) {
				if(tmp%10==1) ans++;
				tmp/=10;
			}
		}
		
		return ans;
    }
}
