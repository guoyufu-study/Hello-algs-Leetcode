package com.jasper.algs.leetcode.sorting.qu0075.solu2;

/**
 * 双指针：一次遍历
 */
class Solution {
    public void sortColors(int[] nums) {
    	int N = nums.length;
    	
    	// 边界
    	if(N <= 1) return;
    	
    	int left=0;// 双指针
    	
    	// 排0
    	left = sortOneColors(nums, 0, N-1, 0);
		
		// 排 1
    	sortOneColors(nums, left, N-1, 1);
    	
    	// 2 有序
    	System.out.println();
    }

    /**
     * 双指针，排好指定颜色
     * 
     * @param nums	原数组
     * @param left	左指针
     * @param right	右指针
     * @param color	要排好的颜色
     * @return	左指针最终位置
     */
	private int sortOneColors(int[] nums, int left, int right, int color) {
		while(left < right) {
			if(nums[left]==color) left++;
			else {
				swap(nums, left, right);
				right--;
			}
		}
		return left < nums.length && nums[left]==color ? ++left : left;
	}

	/**
	 * 交换元素
	 * 
	 * @param nums	原数组
	 * @param left	元素索引
	 * @param right	另一个元素索引
	 */
	private void swap(int[] nums, int left, int right) {
		if(left == right || nums[left]==nums[right]) return;
		nums[left] = nums[left] ^ nums[right];
		nums[right] = nums[left] ^ nums[right];
		nums[left] = nums[left] ^ nums[right];
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[] {0, 0};
//		int[] nums = new int[] {0};
//		int[] nums = new int[] {2,0,2,1,1,0};
		
		new Solution().sortColors(nums);
	}
}