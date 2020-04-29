package com.jasper.algs.leetcode.dynamicprogramming.qu1422.solu1;

/**
 * 1422. 分割字符串的最大得分
 *
 * <p> 动态规划
 */
class Solution {
    public int maxScore(String s) {
    	// 边界处理
    	int N = s.length();
    	if(N<=1) return 0;
    	
    	// 统计左子序列中0的个数
    	int[] helper = new int[N];
    	helper[0] = s.charAt(0) == '0' ? 1 : 0;
		for (int i = 1; i < N-1; i++) { // 不统计N-1索引上的0
			helper[i] = s.charAt(i)=='0'? helper[i-1] + 1 : helper[i-1];
		}
		
		int ans = 0;
		int nums = 0;
		for (int i = N-1; i > 0; i--) { // 不统计0索引上的1
			// 统计右子序列中1的个数
			if(s.charAt(i) == '1') nums++;
			// 更新最大值
			ans = Math.max(ans, helper[i-1]+nums);
		}
		
    	return ans;
    }
    
    public static void main(String[] args) {
//		String s = "1111";
		String s = "011101";
		
		System.out.println(new Solution().maxScore(s));
	}
}