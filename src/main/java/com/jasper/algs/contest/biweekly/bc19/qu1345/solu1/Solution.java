package com.jasper.algs.contest.biweekly.bc19.qu1345.solu1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1345. 跳跃游戏 IV
 * 
 * <p>
 * BFS
 */
class Solution {
	public int minJumps(int[] arr) {

		int n = arr.length;
		if (n == 1)
			return 0;
		
		// 等值处理
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], new LinkedList<Integer>());
			map.get(arr[i]).add(i);
		}

		// BFS
		boolean[] visited = new boolean[n];// 标记已访问
		visited[0] = true;
		Deque<Integer> queue = new LinkedList<>();// 记录待处理
		queue.offer(0);
		int ans = 0;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int index = queue.poll();
				
				// 左侧
				int left = index - 1;
				if (0 < left && !visited[left]) {
					if (left == n - 1)
						return ++ans;
					queue.offer(left);
					visited[left] = true;
				}
				
				// 右侧
				int right = index + 1;
				if (right < n && !visited[right]) {
					if (right == n - 1)
						return ++ans;
					queue.offer(right);
					visited[right] = true;
				}

				// 等值
				List<Integer> equals = map.get(arr[index]);
				if (equals != null) {
					for (int eqi : equals) {
						if (!visited[eqi]) {
							if (eqi == n - 1)
								return ++ans;
							queue.offer(eqi);
							visited[eqi] = true;
						}
					}
					map.remove(arr[index]);
				}
			}
			++ans;
		}

		return -1;// 不可达
	}

	public static void main(String[] args) {

		// 3
//		int[] arr = new int[] {100,-23,-23,404,100,23,23,23,3,404};

		// 0
//		int[] arr = new int[] {7};

		// 1
//		int[] arr = new int[] {7,6,9,6,9,6,9,7};

		// 2
//		int[] arr = new int[] {6,1,9};

		// 3
//		int[] arr = new int[] {11,22,7,7,7,7,7,7,7,22,13};

		// 5
		int[] arr = new int[] { -76, 3, 66, -32, 64, 2, -19, -8, -5, -93, 80, -5, -76, -78, 64, 2, 16 };

		System.out.println(new Solution().minJumps(arr));
	}
}