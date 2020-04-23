package com.jasper.algs.leetcode.dynamicprogramming.qu1186.solu2;

/**
 * 1186. 删除一次得到子数组最大和
 * 
 * <p>
 * 动态规划（优化）
 */
class Solution {
    public int maximumSum(int[] arr) {
    	// 边界
    	int N = arr.length;
    	if(N==1) return arr[0];
    	
    	// 不删除元素时，以i结尾的，连续子数组，元素的，最大和。
    	int sumAll = arr[0] <= 0? arr[1] : arr[0]+arr[1];//初始i=1
    	// 删除元素时，以i结尾的，连续子数组，元素的，最大和
    	int sumDel = Math.max(arr[0], arr[1]);//初始i=1
    	// 答案
    	int ans = Math.max(sumAll, sumDel);
    	
    	for (int i = 2; i < N; i++) {
			sumDel = Math.max(sumAll, sumDel+arr[i]);
    		sumAll = sumAll<=0? arr[i] : sumAll+arr[i];
			ans = Math.max(ans, Math.max(sumAll, sumDel));
		}
		
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] arr = new int[] {-1, -1, -1, -1};
		
		System.out.println(new Solution().maximumSum(arr));
	}
}