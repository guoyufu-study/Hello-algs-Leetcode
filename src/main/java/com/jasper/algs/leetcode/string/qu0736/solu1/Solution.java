package com.jasper.algs.leetcode.string.qu0736.solu1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 0736. Lisp 语法解析
 * 
 * <p> 递归分析法
 */
class Solution {
	// 作用域
    List<Map<String, Integer>> scope = new ArrayList<>();
    
    public int evaluate(String expression) {
        scope.add(new HashMap<String, Integer>());
        int ans = evaluate_inner(expression);
        scope.remove(scope.size()-1);
        return ans;
    }

    int evaluate_inner(String expression) {
        if(expression.charAt(0)!='(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') // 数字常量
                return Integer.parseInt(expression);
            for (int i = scope.size() - 1; i >= 0; --i) { // 变量标识符
                if (scope.get(i).containsKey(expression))
                    return scope.get(i).get(expression);
            }
        }

        // 清除最外层括号
        List<String> tokens = parse(expression.substring(
                expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        
        if(expression.startsWith("add", 1)) // 加
            return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
        
        if(expression.startsWith("mult", 1)) // 乘
            return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
        
        for(int i=1; i<tokens.size(); i+=2) // 赋值+运算
            scope.get(scope.size()-1).put(tokens.get(i-1), evaluate(tokens.get(i)));
        return evaluate(tokens.get(tokens.size()-1));
    }

    List<String> parse(String expression) {
        List<String> ans = new ArrayList<>();
        int bal = 0;
        StringBuilder buf = new StringBuilder();
        for(String token : expression.split(" ")) {
            for(char c : token.toCharArray()) {
                if(c=='(') bal++;
                if(c==')') bal--;
            }
            if(buf.length()>0) buf.append(" ");
            buf.append(token);
            if(bal==0) {
                ans.add(new String(buf));
                buf = new StringBuilder();
            }
        }

        return ans;
    }
}