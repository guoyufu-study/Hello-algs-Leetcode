package com.jasper.algs.interview.q1610.solu;

/**
 * 面试题 16.10. 生存人数
 * 
 * <p> 2 刷
 */
public class Solution {

	public int maxAliveYear(int[] birth, int[] death) {
		
		return 1900;
    }
	
	public static void main(String[] args) {
		int[] birth = new int[] {1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901};
		int[] death = new int[] {1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969};

		System.out.println(new Solution().maxAliveYear(birth, death));
	}
}
