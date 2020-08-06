package com.jasper.algs.leetcode.string.qu0008.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 0008. 字符串转换整数 (atoi)
 * 
 * <p>
 * 自动机
 */
class Solution {

	class Automaton {
		final String START = "start";
		final String SIGNED = "signed";
		final String IN_NUM = "in_number";
		final String END = "end";
		String state = START;
		Map<String, String[]> map;
		public int sign = 1;
		public long ans = 0;

		public Automaton() {
			map = new HashMap<>();
			map.put(START, new String[] { START, SIGNED, IN_NUM, END });
			map.put(SIGNED, new String[] { END, END, IN_NUM, END });
			map.put(IN_NUM, new String[] { END, END, IN_NUM, END });
			map.put(END, new String[] { END, END, END, END });
		}

		public int get_col(char c) {
			if (c == ' ')
				return 0;
			if (c == '+' || c == '-')
				return 1;
			if (c >= '0' && c <= '9')
				return 2;
			return 3;
		}

		public void get(char c) {
			state = map.get(state)[get_col(c)];
			if (state.equals(IN_NUM)) {
				ans = ans * 10 + c - '0';
				if (sign == 1) {
					ans = Math.min(ans, Integer.MAX_VALUE);
				} else {
					// -(long)Integer.MIN_VALUE，这个操作有点东西，不然越界
					ans = Math.min(ans, -(long) Integer.MIN_VALUE);
				}
			} else if (state.equals(SIGNED))
				sign = c == '+' ? 1 : -1;
		}
	}

	public int myAtoi(String str) {

		Automaton automaton = new Automaton();
		char[] c = str.toCharArray();
		for (char ch : c) {
			automaton.get(ch);
		}
		return automaton.sign * ((int) automaton.ans);
	}

	public static void main(String[] args) {

//		String str = "42";

		// 空格开头
//		String str = "   42";

		// 正负号开头
//		String str = "+42";
//		String str = "-42";

		// 空格+正负号
		String str = "   -42";

		// 字符串开头
//		String str = "words and 987";

		// 数字开头
//		String str = "4193 with words";

		// 边界值处理
//		String str = "2147483648";
//		String str = "2147483647";
//    	String str = "2147483646";

//		String str = "-2147483649";
//		String str = "-2147483648";
//		String str = "-2147483647";
//		String str = "-91283472332";

		int atoi = new Solution().myAtoi(str);
		System.out.println(atoi);
	}
}