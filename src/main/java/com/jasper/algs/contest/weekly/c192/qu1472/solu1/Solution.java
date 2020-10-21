package com.jasper.algs.contest.weekly.c192.qu1472.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1472. 设计浏览器历史记录
 * 
 * <p>
 * 双栈
 */
class BrowserHistory {

	Deque<String> back;
	Deque<String> forward;

	public BrowserHistory(String homepage) {
		back = new LinkedList<>();
		forward = new LinkedList<>();
		back.push(homepage);
	}

	public void visit(String url) {
		forward.clear();
		back.push(url);
	}

	public String back(int steps) {
		while (steps > 0 && back.size()>1) {
			forward.push(back.pop());
			steps--;
		}
		return back.peek();
	}

	public String forward(int steps) {
		while (steps > 0 && !forward.isEmpty()) {
			back.push(forward.pop());
			steps--;
		}
		return back.peek();
	}
}