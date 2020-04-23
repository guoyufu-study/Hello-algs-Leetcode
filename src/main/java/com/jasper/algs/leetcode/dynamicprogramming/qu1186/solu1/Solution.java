package com.jasper.algs.leetcode.dynamicprogramming.qu1186.solu1;

/**
 * 1186. 删除一次得到子数组最大和
 * 
 * <p>
 * 动态规划
 */
class Solution {
    public int maximumSum(int[] arr) {
    	// 边界
    	int N = arr.length;
    	if(N==1) return arr[0];
    	
    	// 找出最优子结构
    	// 这里的连续子数组，不必以0索引开始。
    	
    	// 不删除元素时，以i结尾的，连续子数组，元素的，最大和
		int[] dpAll = new int[N];
		dpAll[0] = arr[0];
		for (int i = 1; i < N; i++) {
			dpAll[i] = dpAll[i-1] <= 0 ? arr[i] : arr[i] + dpAll[i-1]; 
		}
		
		// 删除元素时，以i结尾的，连续子数组，元素的，最大和
		int[] dpDel = new int[N];
		dpDel[0] = arr[0];// 子数组不能为空
		dpDel[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < N; i++) {
			dpDel[i] = Math.max(dpAll[i-1], // 删除arr[i] 
					dpDel[i-1]+arr[i]); // 删除另一个
		}
		
		int ans = arr[0];
		for (int i = 1; i < N; i++) {
			ans = Math.max(ans, Math.max(dpAll[i], dpDel[i]));
		}
		
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] arr = new int[] {-1, -1, -1, -1};
		
		System.out.println(new Solution().maximumSum(arr));
	}
}