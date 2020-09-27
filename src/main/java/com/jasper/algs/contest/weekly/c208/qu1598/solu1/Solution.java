package com.jasper.algs.contest.weekly.c208.qu1598.solu1;

/**
 * 1598. 文件夹操作日志搜集器
 * 
 * <p> 简单计数
 */
class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for(String log : logs) {
            if(log.equals("../")) ans = ans==0 ? 0 : --ans;
            else if(log.equals("./")) ; // 什么都不做
            else ans++;
        }
        return ans;
    }
}