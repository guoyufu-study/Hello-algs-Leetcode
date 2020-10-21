package com.jasper.algs.contest.weekly.c192.qu1472.solu2;

/**
 * 1472. 设计浏览器历史记录
 * 
 * <p> 数组+双指针
 */
class BrowserHistory {
	
    private int pos = -1;
    private int top = -1;
    private final String[] history = new String[5001];

    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        top = ++pos;
        history[top] = url;
    }

    public String back(int steps) {
        pos = Math.max(0, pos-steps);
        return history[pos];
    }

    public String forward(int steps) {
        pos = Math.min(top, pos+steps);
        return history[pos];
    }
}