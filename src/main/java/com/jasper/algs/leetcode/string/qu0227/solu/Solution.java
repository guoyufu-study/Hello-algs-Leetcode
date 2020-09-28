package com.jasper.algs.leetcode.string.qu0227.solu;

/**
 * 0227. 基本计算器 II
 * 
 * <p> 6 刷
 */
class Solution {
    public int calculate(String s) {
        int ans = 0, // 最终结果
            tmpAns = 0, // 子表达式临时结果
            num = 0; // 新数字
        char opt = '+'; // 操作符
        int index = 0, n = s.length();
        while( index < n ) {
            char ch = s.charAt(index);

            // 数字
            if(Character.isDigit(ch)) 
                num = num * 10 + ch - '0';

            // 运算符
            if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || index == n-1) {
                switch (opt) {// 子表达式
                    case '+' : tmpAns += num; break;
                    case '-' : tmpAns -= num; break;
                    case '*' : tmpAns *= num; break;
                    case '/' : tmpAns /= num; break;
                }
                
                // 汇总子表达式
                if(ch=='+' || ch=='-' || index == n-1) {
                    ans += tmpAns;
                    tmpAns = 0;
                }

                opt = ch;
                num = 0;
            }

            index++;
        }

        return ans;
    }
}