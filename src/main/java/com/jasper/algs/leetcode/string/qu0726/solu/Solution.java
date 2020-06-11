package com.jasper.algs.leetcode.string.qu0726.solu;

/**
 * 0726. 原子的数量
 * 
 * <p> 2 刷
 */
class Solution {
	
	public String countOfAtoms(String formula) {
		StringBuilder ans = new StringBuilder();
		
		return ans.toString();
	}

	public static void main(String[] args) {
		
		// H2O
//		String formula = "H2O";
		
		// H2MgO2
//		String formula = "Mg(OH)2";
		
		// K4N2O14S4
//		String formula = "K4(ON(SO3)2)2";
		
		// "B7H11He49Li20N47O35"
		String formula = "H11He49NO35B7N46Li20";
		
		System.out.println(new Solution().countOfAtoms(formula));
	}
}
