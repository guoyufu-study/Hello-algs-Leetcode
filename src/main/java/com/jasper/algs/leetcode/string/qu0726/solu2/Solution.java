package com.jasper.algs.leetcode.string.qu0726.solu2;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 0726. 原子的数量
 * 
 * <p> 辅助栈
 */
class Solution {

	public String countOfAtoms(String formula) {
		
		int N = formula.length();
		
		// 解析字符串
		Stack<Map<String, Integer>> stack = new Stack<>();
		stack.push(new TreeMap<>());
		int i = 0;
		while (i < N) {
			
			// ( 
			if(formula.charAt(i)=='(') {
				// 创建 map 并入栈
				stack.push(new TreeMap<String, Integer>());
				i++;
			} 
			
			// )
			else if(formula.charAt(i)==')') {
				// 元素数量
				int iStart = ++i;
				while(i<N && Character.isDigit(formula.charAt(i))) i++;
				int multiplicity = i>iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
				
				// 出栈
				Map<String, Integer> top = stack.pop();
				Map<String, Integer> peek = stack.peek();
				for (String name : top.keySet()) {
					peek.put(name, 
							peek.getOrDefault(name, 0) + top.get(name)*multiplicity);
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
				
				Map<String, Integer> peek = stack.peek();
				peek.put(name, peek.getOrDefault(name, 0) + multiplicity);
			}
			
		}
		
		//  构造答案
		Map<String, Integer> helper = stack.pop();
		StringBuilder ans = new StringBuilder();
		for (String name : helper.keySet()) {
			ans.append(name);
			int multiplicity = helper.get(name);
			if(multiplicity>1)
				ans.append(multiplicity);
		}
		
		return ans.toString();
	}

	public static void main(String[] args) {
		
		// H2O
//		String formula = "H2O";
		
		// H2MgO2
//		String formula = "Mg(OH)2";
		
		// K4N2O14S4
		String formula = "K4(ON(SO3)2)2";
		
		System.out.println(new Solution().countOfAtoms(formula));
	}
}
