package com.jasper.algs.contest.weekly.c120.qu0978.solu1;

/**
 * 0978. 最长湍流子数组
 *
 * <p> 滑动窗口
 */
class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if(n==1) return n;
        
        int ans = A[0]==A[1] ? 1 : 2;
        int left = 0, right = 2;
        while(right<n) {
        	int a = A[right-1]-A[right-2];
            int b = A[right]-A[right-1];
            if((a<0 && b>0) || (a>0 && b<0))  {
        		ans = Math.max(ans, right - left + 1);
        	} else {
        		left = right - 1;
        	}
            
        	right++;
        }
        
        return ans;
//        for(int right=1; right<n; right++) {
//        	int c = Integer.compare(A[right-1], A[right]);
//        	if(right==n-1 || c * Integer.compare(A[right], A[right+1]) != -1) {
//        		if(c != 0) ans = Math.max(ans, right-left+1);
//        		left = right;
//        	}
//        }
//        
//    	return ans;
    }
    
    public static void main(String[] args) {
    	// 5
//		int[] A = new int[] {0,1,1,0,1,0,1,1,0,0};
		
		// 8
		int[] A = new int[] {0,8,45,88,48,68,28,55,17,24};
		System.out.println(new Solution().maxTurbulenceSize(A));
	}
}