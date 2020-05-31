package com.jasper.algs.leetcode.maths.qu0233.solu1;

/**
 * 0233. 数字 1 的个数
 * 
 * <p>暴力枚举（超时）
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
