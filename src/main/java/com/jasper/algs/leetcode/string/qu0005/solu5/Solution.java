package com.jasper.algs.leetcode.string.qu0005.solu5;

/**
 * 0005. 最长回文子串
 * 
 * <p> Manacher 算法（马拉车算法）
 */
public class Solution {

	public String longestPalindrome(String s) {
		// 边界
		if(s==null || s.length()<=1) {
			return s;
		}
		
		// 处理原字符串，转换成新字串
		StringBuilder sb = new StringBuilder();
		sb.append('#');
		for (char c : s.toCharArray()) {
			sb.append(c);
			sb.append('#');
		}
		s = sb.toString();
		
		// Manacher 算法 <= 中心扩展法
		int start = 0, end = -1;
		int center = -1, maxRight = -1;
		int[] armLen = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			// 当前臂长
			int minArmLen = maxRight >= i ? 
					Math.min(armLen[2*center - i], maxRight - i) : 0;// 最小臂长
			int curArmLen = expandAroundCenter(s, i-minArmLen-1, i+minArmLen+1);
			
			// 缓存臂长
			armLen[i] = curArmLen;
			
			// 更新右边界及中心
			int right = curArmLen+i;
			if(right>maxRight) {
				maxRight = right;
				center = i;
			}
			
			// 更新最长回文串
			if(2*curArmLen + 1 > end - start + 1) {
				start = i - curArmLen;
				end = i + curArmLen;
			}
			
		}
		
		// 构造答案
		StringBuilder ans = new StringBuilder();
		for (int i = start; i <= end; i++) {
			if(s.charAt(i)=='#') continue;
			ans.append(s.charAt(i));
		}
		
		return ans.toString();
		
		
	}
	
	/**
	 * 中心扩展
	 */
	private int expandAroundCenter(String s, int i, int j) {
		while(i>=0 && j< s.length() && s.charAt(i)==s.charAt(j)) {
			i--;
			j++;
		}
		return (j-i-1)/2;
	}

	public static void main(String[] args) {
		// bab
//		String s = "babad";
		
		// bb
//		String s = "cbbd";
		
		// bb
		String s = "bb";
		
		System.out.println(new Solution().longestPalindrome(s));
	}
}
