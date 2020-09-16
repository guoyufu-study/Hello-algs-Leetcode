package com.jasper.algs.sword2offer.qu059ii.solu1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 *
 * <p>
 * 单调非递增双向队列
 */
class MaxQueue {

	public Deque<Integer> maxs = null;// 双端队列，链表结构，维护很多的最大值
	public Queue<Integer> data = null;// 数据队列

	public MaxQueue() {
		maxs = new LinkedList<Integer>();
		data = new LinkedList<Integer>();
	}

	public int max_value() {
		if (data == null || data.size() == 0) return -1;
		
		// 最大值队列的队首
		return (int) maxs.peek(); 
	}

	public void push_back(int value) {
		data.offer(value);
		// 最大值队列,是一个双端队列
		// 思想：矮个儿后有高个儿进来，那矮个儿永无出头之日，直接踢掉即可。
		// value 若比队尾大，删除队尾（一直重复，直到value比队尾小），value 入队
		// 总结起来，就是从队尾开始踢，把前面比我小的全踢掉。自己入队

		while ((maxs.peekLast() != null) && (maxs.peekLast() < value)) {
			maxs.pollLast();
		}
		maxs.offer(value);
	}

	public int pop_front() {
		if (data.peek() == null)  return -1;
		
		// 两个队列 队首相同，就同时队首 出队
		if ((int) data.peek() == (int) maxs.peek())
			maxs.poll();
		
		// 否则，仅需 数据队列出队
		return data.poll();
		
	}
}

/**
 * Your MaxQueue object will be instantiated and called as such: MaxQueue obj =
 * new MaxQueue(); int param_1 = obj.max_value(); obj.push_back(value); int
 * param_3 = obj.pop_front();
 */