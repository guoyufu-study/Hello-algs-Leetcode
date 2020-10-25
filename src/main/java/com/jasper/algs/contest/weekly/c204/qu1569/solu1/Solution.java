package com.jasper.algs.contest.weekly.c204.qu1569.solu1;

/**
 * 1569. 将子数组重新排序得到同一个二叉查找树的方案数
 * 
 * <p> 动态规划 + 组合计数
 */
class Solution {
	
	int MOD = 1_000_000_007;
	
    public int numOfWays(int[] nums) {
    	int n = nums.length;
    	
    	// 组合缓存
    	long[][] c = new long[n][n];
    	c[0][0] = 1;
    	for(int i=1; i<n; i++) {
    		c[i][0] = 1;
    		for(int j=1; j<=i; j++) 
    			c[i][j] = (c[i-1][j] + c[i-1][j-1])%MOD;
    	}
    	
    	// 构造树
    	TreeNode root = new TreeNode(nums[0]);
    	for(int i=1; i<n; i++) 
    		insert(root, nums[i]);
    	
    	// LDR
    	lrd(root, c);
    	
    	return root.ans - 1;
    }
    
    void lrd(TreeNode root, long[][] c) {
    	if(root==null) return ;
    	
    	lrd(root.left, c);
    	lrd(root.right, c);
    	
    	int lsize = root.left==null ? 0 : root.left.size;
    	int rsize = root.right==null ? 0 : root.right.size;
    	int lans = root.left==null ? 1 : root.left.ans;
    	int rans = root.right==null ? 1 : root.right.ans;
    	
    	root.size += lsize + rsize;
    	root.ans = (int)((c[lsize+rsize][lsize] * lans)%MOD * rans%MOD);
	}

	void insert(TreeNode root, int num) {
    	while(root.val != num) {
    		if(root.val > num) {
    			if(root.left==null) 
    				root.left = new TreeNode(num);
    			root = root.left;
    		} else {
    			if(root.right==null)
    				root.right = new TreeNode(num);
    			root = root.right;
    		}
    	}
	}

	class TreeNode {
    	TreeNode left, right;
    	int val, size, ans;
    	TreeNode(int val) {
    		this.val = val;
    		size = 1;
    		ans = 0;
    	}
    }
    
    public static void main(String[] args) {
    	// 10
//		System.out.println(new Solution().c(3,5));
//		System.out.println(new Solution().cal(2,3));
    	
    	// 19
//    	int[] nums = new int[] {3,1,2,5,4,6};
    	
    	// 5
//    	int[] nums = new int[] {3,4,5,1,2};
    	
    	// 0
//    	int[] nums = new int[] {1,2,3};
    	
    	// 216212978
    	int[] nums = new int[] {9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18};
//    	int[] nums = new int[] {4,2,1,3,6,5,7,8};
//    	int[] nums = new int[] {14,11,10,12,13,16,15,17,18};
//    	int[] nums = new int[] {16,15,17,18};
    	
    	
    	System.out.println(new Solution().numOfWays(nums));
	}
}