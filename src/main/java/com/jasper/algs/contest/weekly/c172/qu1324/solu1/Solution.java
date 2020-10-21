package com.jasper.algs.contest.weekly.c172.qu1324.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 1324. 竖直打印单词
 * 
 * <p> 模拟
 */
class Solution {
    public List<String> printVertically(String s) {
        // 将字符串切分成单词列表
        String[] words = s.split("\\s");

        // 计算最长单词长度
        int len = 0;
        for(String word : words)
            len = Math.max(len, word.length());
        
        // 模拟构造
        List<String> ans = new ArrayList<>();
        for(int i=0; i<len; i++) {
            StringBuilder tmp = new StringBuilder("!");
            for(String word : words) {
                tmp.append(i>=word.length() ? ' ' : word.charAt(i));
            }
            ans.add(tmp.toString().trim().substring(1));
        }
        
        return ans;
    }
}