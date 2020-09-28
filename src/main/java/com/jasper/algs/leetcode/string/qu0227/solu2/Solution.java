package com.jasper.algs.leetcode.string.qu0227.solu2;

/**
 * 0227. 基本计算器 II
 * 
 * <p>
 * 递归
 */
class Solution {
	int index = 0, level = 0;

	public int calculate(String s) {
		return calculate(s, 0, '+');
	}

	int calculate(String s, int rest, char opt) {
		while (index < s.length()) {
			while (index < s.length() && s.charAt(index) == ' ')
				index++;// 空格
			int num = 0;// 数字
			while (index < s.length() && Character.isDigit(s.charAt(index))) {
				num = num * 10 + s.charAt(index++) - '0';
			}
			while (index < s.length() && s.charAt(index) == ' ')
				index++;// 空格
			// 计算
			char nopt = index == s.length() ? '+' : s.charAt(index++);
			if (((opt == '+' || opt == '-') && (nopt == '+' || nopt == '-'))
					|| ((opt == '*' || opt == '/') && (nopt == '*' || nopt == '/'))) {// 同级
				if (opt == '+')
					rest += num;
				else if (opt == '-')
					rest -= num;
				else if (opt == '*')
					rest *= num;
				else if (opt == '/')
					rest /= num;
				opt = nopt;
			} else if ((opt == '+' || opt == '-') && (nopt == '*' || nopt == '/')) {
				level++;
				num = calculate(s, num, nopt);
				if (opt == '+')
					rest += num;
				else if (opt == '-')
					rest -= num;
				opt = index == s.length() ? '+' : s.charAt(index - 1);
			} else {
				if (opt == '*')
					rest *= num;
				else if (opt == '/')
					rest /= num;
				if (level != 0) {
					level--;
					return rest;
				}
				opt = nopt;
			}
		}

		return rest;
	}
}