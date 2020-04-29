package com.jasper.algs.leetcode.permutation.qu0031.solu1;

/**
 * 0031. 下一个排列
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
    	
    	int N = nums.length;
    	
    	// 找出增加点
    	int modifiedIndex = -1;
		for (int i = N-1; i > 0; i--) {
			if(nums[i-1] < nums[i]) {// 非递减序列的终点 i
				modifiedIndex = i-1;
				break;
			}
		}
		
		// 已是最大值，逆序返回
		if(modifiedIndex==-1) {
			reverseArray(nums, modifiedIndex+1, N);
			return ;
		}
		
		// 找出第一个比 nums[index]大的数（非递减序列的终点）
		int biggerIndex = 0;
		for (int i = N-1; i > modifiedIndex; i--) {
			if(nums[modifiedIndex] < nums[i]) {
				biggerIndex = i;
				break;
			}
		}
		
		// 交换
		int tmp = nums[modifiedIndex];
		nums[modifiedIndex] = nums[biggerIndex];
		nums[biggerIndex] = tmp;
		
		// 逆序
		reverseArray(nums, modifiedIndex+1, N);
    }
    
    /**
     * // 逆序
     * @param nums
     * @param start
     * @param end
     */
    private void reverseArray(int[] nums, int start, int end) {
		for (int i = start; i < end; i++) {
			int j = end-1-(i-start);
			if(i>=j) break;
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
    }
    
    public static void main(String[] args) {
//		int[] nums = new int[] {3,2,1};
    	int[] nums = new int[] {2,3,1};
//		int[] nums = new int[] {1,2,3};
		
		
		new Solution().nextPermutation(nums);
	}
}