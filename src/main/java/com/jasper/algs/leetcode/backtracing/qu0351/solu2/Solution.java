package com.jasper.algs.leetcode.backtracing.qu0351.solu2;

import java.util.HashSet;
import java.util.Set;

/**
 * 0351. 安卓系统手势解锁
 * 
 * <p> 回溯
 */
class Solution {
	// 标记已选数字
	private boolean[] used = new boolean[10];
	
	// 索引：last 上一次选中的数字
	// 值： 需要判断used[used]的数字
	@SuppressWarnings("unchecked")
	private static Set<Integer>[] helper = new Set[10];
	
	static {
		for (int i = 1; i < 10; i++)
			helper[i] = new HashSet<Integer>();
		
		helper[1].add(3);
		helper[1].add(7);
		helper[1].add(9);
		
		helper[2].add(8);
		
		helper[3].add(1);
		helper[3].add(7);
		helper[3].add(9);
		
		helper[4].add(6);
		
		helper[6].add(4);
		
		helper[7].add(1);
		helper[7].add(3);
		helper[7].add(9);
		
		helper[8].add(2);
		
		helper[9].add(1);
		helper[9].add(3);
		helper[9].add(7);
	}
	
	public int numberOfPatterns(int m, int n) {
		int ans = 0;
		for (int len = m; len <= n; len++) {
			used[1] = true;
			ans += calcPatterns(1, len-1) * 4;
			used[1] = false;
			
			used[2] = true;
			ans += calcPatterns(2, len-1) * 4;
			used[2] = false;
			
			used[5] = true;
			ans += calcPatterns(5, len-1);
			used[5] = false;
		}
		
		return ans;
	}

	private int calcPatterns(int last, int len) {
		
		if(len==0) return 1;
		
		int sum = 0;
		
		for (int i = 1; i < 10; i++) {
			// 剪枝
			if(!isValid(i, last)) continue;
			
			// 选择
			used[i] = true;
			
			// 下一步
			sum += calcPatterns(i, len-1);
			
			// 回溯
			used[i] = false;
		}
		
		return sum;
	}

	
	private boolean isValid(int index, int last) {
		
		// 已被选过
		if(used[index])
			return false;
		
		// 经过中间一个点
		if(helper[last].contains(index))
			return used[(last+index)/2];
		
		// 其它
		return true;
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
