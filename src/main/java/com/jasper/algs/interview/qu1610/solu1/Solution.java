package com.jasper.algs.interview.qu1610.solu1;

/**
 * 面试题 16.10. 生存人数
 * 
 * <p>暴力求解：逐年统计生存 人数
 */
public class Solution {

	public int maxAliveYear(int[] birth, int[] death) {
		int[] alive = new int[101];
		for (int i = 0; i < alive.length; i++) {//逐年统计
			for (int j = 0; j < birth.length; j++) {//存在很多无效遍历
				if(birth[j]<=1900+i && death[j]>=1900+i)
					alive[i]++;
			}
		}
		
		int ans=1900, maxAlive=alive[0];
		for (int i = 1; i < alive.length; i++) {//查记录
			if(alive[i]>maxAlive) {
				maxAlive=alive[i];
				ans = 1900+i;
			}
		}
		return ans;
    }
}
