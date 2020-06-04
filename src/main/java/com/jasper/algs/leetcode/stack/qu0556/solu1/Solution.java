package com.jasper.algs.leetcode.stack.qu0556.solu1;

/**
 * 0556. 下一个更大的元素 III
 * 
 * <p>
 * 单调栈
 */
class Solution {
	
	public int nextGreaterElement(int n) {

		char[] a = String.valueOf(n).toCharArray();
		
		// 从右往左扫描每一对连续的数字，找到第一个递减数字的索引 i
		int i = a.length - 2;
		while (i >= 0 &&  a[i] >= a[i + 1]) {
			i--;
		}
		
		// 没找到，n 已是最大
		if (i < 0)
			return -1;
		
		// 从右往左，找到第一个比 a[i] 大的数字的索引 j
		int j = a.length - 1;
		while (j >= 0 && a[j] <= a[i]) {
			j--;
		}
		// 交换 i j
		swap(a, i, j);
		// 逆序 [i+1, length-1]
		reverse(a, i + 1);
		
		// 构造答案
		try {
			return Integer.parseInt(new String(a));
		} catch (Exception e) {
			// 溢出
			return -1;
		}
	}

	private void reverse(char[] a, int start) {
		int i = start, j = a.length - 1;
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
	}

	private void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// 21
//		int n = 12;

		// -1
//		int n = 21;

		// 230421
//		int n = 230241;

		// 13222344
		int n = 12443322;

		System.out.println(new Solution().nextGreaterElement(n));
	}
}
