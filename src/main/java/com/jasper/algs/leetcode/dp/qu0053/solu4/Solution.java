package com.jasper.algs.leetcode.dp.qu0053.solu4;

/**
 * 0053. 最大子序和
 * 
 * <p> 分治
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length-1).mSum;
    }
    
    private Status getInfo(int[] nums, int left, int right) {
    	if(left==right)
    		return new Status(nums[left]);
    	int mid = (left+right)>>1;
		return pushUp(getInfo(nums, left, mid), getInfo(nums, mid+1, right));
	}

	class Status {
    	int lSum, rSum, mSum, iSum;
    	public Status(int sum) {
			this(sum, sum, sum, sum);
		}
		public Status(int lSum, int rSum, int mSum, int iSum) {
			super();
			this.lSum = lSum;
			this.rSum = rSum;
			this.mSum = mSum;
			this.iSum = iSum;
		}
    }
    
    private Status pushUp(Status l, Status r) {
    	int lSum = Math.max(l.lSum, l.iSum + r.lSum);
    	int rSum = Math.max(l.rSum + r.iSum, r.rSum);
    	int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
    	int iSum = l.iSum + r.iSum;
		return new Status(lSum , rSum, mSum, iSum);
    }
}