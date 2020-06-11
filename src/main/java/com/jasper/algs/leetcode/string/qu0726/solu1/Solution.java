package com.jasper.algs.leetcode.string.qu0726.solu1;

import java.util.Map;
import java.util.TreeMap;

/**
 * 0726. 原子的数量
 * 
 * <p> 递归
 */
class Solution {
	
	private int i;
	private int N;
	
	public String countOfAtoms(String formula) {
		
		N = formula.length();
		i = 0;
		
		// 解析字符串
		Map<String, Integer> helper = parse(formula);
		
		//  构造答案
		StringBuilder ans = new StringBuilder();
		for (String name : helper.keySet()) {
			ans.append(name);
			int multiplicity = helper.get(name);
			if(multiplicity>1)
				ans.append(multiplicity);
		}
		
		return ans.toString();
	}

	private Map<String, Integer> parse(String formula) {
		TreeMap<String, Integer> count = new TreeMap<String, Integer>();
		
		while(i<N && formula.charAt(i)!=')') {
			// ( ：递归统计 （..)n 
			if(formula.charAt(i)=='(') {
				i++;
				for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
					count.compute(entry.getKey(), 
							(key, value) -> value==null ? entry.getValue() : value+entry.getValue());
				}
			} 
			
			// 大写字母
			else {
				// 大写字母开头
				assert Character.isUpperCase(formula.charAt(i)) : "输入错误...";
				
				// 元素名
				int iStart = i++;
				while(i<N && Character.isLowerCase(formula.charAt(i))) i++;
				String name = formula.substring(iStart, i);
				
				// 元素数量
				iStart = i;
				while(i<N && Character.isDigit(formula.charAt(i))) i++;
				int multiplicity = iStart<i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
				
				count.compute(name, 
						(key, value) -> value==null ? multiplicity : value+multiplicity);
			}
		}
		
		// ) 计数
		int iStart = ++i;
		while(i<N && Character.isDigit(formula.charAt(i))) i++;
		if(iStart<i) {
			int multiplicity = Integer.parseInt(formula.substring(iStart, i));
			
			for (String key : count.keySet()) {
				count.put(key, count.get(key) * multiplicity);
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		// H2O
//		String formula = "H2O";
		
		// H2MgO2
		String formula = "Mg(OH)2";
		
		// K4N2O14S4
//		String formula = "K4(ON(SO3)2)2";
		
		System.out.println(new Solution().countOfAtoms(formula));
	}
}
