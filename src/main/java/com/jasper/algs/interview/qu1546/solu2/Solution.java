package com.jasper.algs.interview.qu1546.solu2;

/**
 * 面试题 16.10. 生存人数
 * 
 * <p>优化暴力求解：逐人统计生存人数
 */
public class Solution {

	public int maxAliveYear(int[] birth, int[] death) {
		int[] alive = new int[101];
		for (int i = 0; i < birth.length; i++) {//统计：逐人统计
			for (int j = birth[i]-1900; j <= death[i]-1900; j++) {//避免了很多无效遍历
				alive[j]++;
			}
		}
		
		int ans=1900, maxAlive=alive[0];
		for (int i = 0; i < alive.length; i++) {//查记录
			if(alive[i]>maxAlive) {
				maxAlive=alive[i];
				ans = 1900+i;
			}
		}
		return ans;
    }
}
