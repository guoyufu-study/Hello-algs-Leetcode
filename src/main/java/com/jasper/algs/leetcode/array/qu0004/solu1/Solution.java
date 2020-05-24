package com.jasper.algs.leetcode.array.qu0004.solu1;

/**
 * 0004.寻找两个有序数组的中位数
 * 
 * <p>二分查找+中位数计算
 */
public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 保证 num1.length <= nums2.length
		if(nums1.length>nums2.length) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
		}
		int m = nums1.length;
		int n = nums2.length;
		
		// 确定 i 和 j
		int left=0, right=m, half=(m+n+1)/2;
		int i=0, j=0;
		while(left<=right) {//二分查找=>确定i
			i=(right-left)/2+left;
			j = half - i;
			if(i>left && nums1[i-1]>nums2[j]) right=i-1;//大了，左移
			else if(i<right && nums2[j-1]>nums1[i]) left=i+1;//小了，右移
			else break; // 找到
		}
		
		//计算中位数，注意边界处理
		int maxLeft = i==0 ? nums2[j-1]:
							j==0? nums1[m-1] : //i==m，且m=n时，可能导致j=0
								Math.max(nums1[i-1], nums2[j-1]);
					
		if((m+n)%2==1) return maxLeft;// 奇数
		
		int minRight= i==m ? nums2[j] :
							j==n ? nums1[0] : //i==0，且m=n时，会导致j=n
								Math.min(nums1[i], nums2[j]);
		
		return (maxLeft+minRight)/2.0; // 偶数
	}
	
	public static void main(String[] args) {
		// 2.0
//		int[] nums1 = new int[] {1,3};
//		int[] nums2 = new int[] {2};
		
		// 2.5
		int[] nums1 = new int[] {1,2};
		int[] nums2 = new int[] {3,4};
		
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
	}
}
