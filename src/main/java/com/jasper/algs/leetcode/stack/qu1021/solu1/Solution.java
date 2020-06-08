package com.jasper.algs.leetcode.stack.qu1021.solu1;

/**
 * 1021. 删除最外层括号
 * 
 * <p>计数器
 */
class Solution {

	public String removeOuterParentheses(String S) {
        StringBuilder ans = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) ans.append(c);
            if (c == '(') ++level;
        }
        return ans.toString();
    }

}
