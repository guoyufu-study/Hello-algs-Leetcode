package com.jasper.algs.leetcode.backtracing.qu0351.solu1;

/**
 * 0351. 安卓系统手势解锁
 * 
 * <p> 回溯
 */
class Solution {
	
	private boolean[] used = new boolean[9];

	public int numberOfPatterns(int m, int n) {
		int ans = 0;
		for (int len = m; len <= n; len++) {
			ans += calcPatterns(-1, len);
			
			for (int i = 0; i < 9; i++) {
				used[i] = false;
			}
		}
		
		return ans;
	}

	private int calcPatterns(int last, int len) {
		
		if(len==0) return 1;
		
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			// 找出可选数字
			if(isValid(i, last)) {
				// 选择
				used[i] = true;
				
				// 下一步
				sum += calcPatterns(i, len-1);
				
				// 回溯
				used[i] = false;
			}
		}
		
		return sum;
	}

	private boolean isValid(int index, int last) {
		
		// 已被选过
		if(used[index])
			return false;
		
		// 第一次选择
		if(last==-1)
			return true;
		
		if((index+last)%2==1) 
			return true;
		
		int mid = (index+last)/2;
		if(mid==4) // 对角线
			return used[mid];
		
		if((index%3 != last%3) && // 不在同一列
				(index/3 != last/3)) // 不在同一行
			return true;
		
		// 其它
		return used[mid];
	}
	
	public static void main(String[] args) {
		
		// 9
//		int m = 1;
//		int n = 1;
		
		// 56
//		int m = 2;
//		int n = 2;
		
		// 320
//		int m = 3;
//		int n = 3;
		
		// 1624
//		int m = 4;
//		int n = 4;
		
		// 7152
//		int m = 5;
//		int n = 5;
		
		// 26016
//		int m = 6;
//		int n = 6;
		
		// 72912
//		int m = 7;
//		int n = 7;
		
		// 140704
//		int m = 8;
//		int n = 8;
		
		// 140704
//		int m = 9;
//		int n = 9;
		
		// 246784
//		int m = 5;
//		int n = 8;
		
		// 248793
		int m = 1;
		int n = 8;
		
		System.out.println(new Solution().numberOfPatterns(m, n));
	}
}
