package com.jasper.algs.interview.q1610.solu3;

/**
 * 面试题 16.10. 生存人数
 * 
 * <p>逐人统计变化
 */
public class Solution {

	public int maxAliveYear(int[] birth, int[] death) {
		int[] changes = new int[102];
		for (int i = 0; i < birth.length; i++) {//存记录
			changes[birth[i]-1900]++;//避免了每次记录一个区间一组值
			changes[death[i]-1900+1]--;
		}
		
		int ans=0, maxAlive=0, currAlive = 0;
		for (int i = 0; i < changes.length; i++) {//查记录
			currAlive += changes[i];
			if(currAlive>maxAlive) {
				maxAlive=currAlive;
				ans = 1900+i;
			}
		}
		return ans;
    }
	
}
