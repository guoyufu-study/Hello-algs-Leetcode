package com.jasper.algs.leetcode.sorting.qu0406.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0406.根据身高重建队列
 * 
 * <p>
 * 排序
 */
class Solution {
	public int[][] reconstructQueue(int[][] people) {

		if (people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];

		// h 降序、 k 升序
		Arrays.parallelSort(people, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);

		// 按k插入
		List<int[]> queue = new ArrayList<>();
		for (int[] p : people) {
			queue.add(p[1], p);
		}

		// 构造答案
		return queue.toArray(new int[queue.size()][]);

	}
}