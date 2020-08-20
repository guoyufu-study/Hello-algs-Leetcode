package com.jasper.algs.leetcode.dp.qu0312.solu1;

/**
 * 0312.戳气球
 * <p>
 * 回溯法
 */
class Solution {
	
	private static int maxCoins = 0;
	
    public int maxCoins(int[] nums) {
    	//空数组处理
        if (nums == null) {
            return maxCoins;
        }

        // 加虚拟边界
    	int[] nums2 = new int[nums.length+2];
    	System.arraycopy(nums, 0, nums2, 1, nums.length);
    	nums2[0] = 1;
    	nums2[nums2.length-1] = 1;
    	
    	// 戳气球
    	maxCoins(nums2, nums.length, 0, maxCoins);
    	
    	return maxCoins;
    }
    
    
    public void maxCoins(int[] nums, int thresholdLevel, int currLevel, int currCoins) {
    	
    	// 回归条件
    	if(currLevel == thresholdLevel) {
    		if(currCoins > maxCoins)
    			maxCoins = currCoins;
    		return ;
    	}
    		
    	// 戳气球（选择一个末被戳破的气球）
    	for (int i = 1; i < nums.length-1; i++) {
			if(nums[i]==-1) continue; // 气球已被戳过，跳过
			
			// 戳破气球，标记一下
			int tmp = nums[i];
			nums[i] = -1;
			
			// 找到前一个气球
			int prev = i-1;
			while(prev>0 && nums[prev]==-1) prev--;

			// 找到后一个气球
			int next = i+1;
			while(next<nums.length-1 && nums[next]==-1) next++;
			
			// 计算得到的金币
			int coins = nums[prev] * tmp * nums[next];
			
			// 继续戳下一个
			maxCoins(nums, thresholdLevel, currLevel+1, currCoins+coins);
			
			// 回溯
			nums[i] = tmp;
		}
    	
    }
    
    public static void main(String[] args) {
//		int[] nums = new int[] {3,1,5,8}; //maxCoins = 167
		
		int[] nums = {3,4,5,6,7,5,7,8,5,3,2,5};//maxCoins = 1918
		
    	// 回溯法用时：15491
        long start = System.currentTimeMillis();
        System.out.println("最多能得到金币："+new Solution().maxCoins(nums));
		System.out.println("原始回溯用时   ：   " + String.valueOf(System.currentTimeMillis() - start)/* +"  运算次 数："+sum3 */);
        		
//        start = System.currentTimeMillis();
//        System.out.println(maxCoins4MS(nums));
//        System.out.println("分治用时   ：   " + 
//        String.valueOf(System.currentTimeMillis() - start)+"  运算次数："+sum1+"  实际运算次数："+sum2);
	}
}