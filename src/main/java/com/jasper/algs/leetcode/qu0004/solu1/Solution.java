package com.jasper.algs.leetcode.qu0004.solu1;

/**
 * 二分查找+中位数计算
 */
public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		
		if(m>n) {//确保 m<=n
			int[] tmp = nums1; nums1 = nums2; nums2 = tmp;
			m = nums1.length;
			n = nums2.length;
		}
		
		if(n==0) // 两数组都无值
			throw new IllegalArgumentException("两个数组全部无值...");
		
		// 确定 i 和 j
		int imin=0, imax=m, halfLen=(m+n+1)/2;
		while(imin<=imax) {//二分查找=>确定i
			int i=(imin+imax)/2;
			int j = halfLen - i;
			if(i<imax && nums2[j-1]>nums1[i]) imin=i+1;//小了，右移
			else if(i>imin && nums1[i-1]>nums2[j]) imax=i-1;//大了，左移
			else break;
		}
		int i=(imin+imax)/2;
		int j = halfLen-i;//确定j
		
		
		//计算中位数，并返回
		int L= i==0 ? nums2[j-1]:
							j==0? nums1[m-1] : //i==m，且m=n时，可能导致j=0
								Math.max(nums1[i-1], nums2[j-1]);
							
		if((m+n)%2==1) return L;
		
		int R= i==m ? nums2[j] :
							j==n ? nums1[0] : //i==0，且m=n时，会导致j=n
								Math.min(nums1[i], nums2[j]);
		return (L+R)/2.0;
	}
}
