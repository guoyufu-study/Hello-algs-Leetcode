package com.jasper.algs.leetcode.greedy.qu0874.solu1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 0874. 模拟行走机器人
 * 
 * <p>
 * 贪心算法
 */
class Solution {
	public int robotSim(int[] commands, int[][] obstacles) {
		// 往前走一步的偏移量：     北、东、南、西
		int[] dx = new int[] { 0, 1, 0, -1 };
		int[] dy = new int[] { 1, 0, -1, 0 };
		// 当前坐标（x,y）、当前方向 di
		int x = 0, y = 0, di = 0;

		// 编码障碍物 (x,y) -> (x+30000) * (2^16) + (y+30000)
		Set<Integer> obstacleSet = new HashSet<>();
		Arrays.stream(obstacles)
			.mapToInt(a -> ((a[0] + 30000) << 16) + (a[1] + 30000))
			.forEach(n -> obstacleSet.add(n));

		int ans = 0;
		for (int cmd : commands) {
			// 左转
			if (cmd == -2) 
				di = (di + 3) % 4;
			
			// 右转
			else if (cmd == -1) 
				di = (di + 1) % 4;
			
			// 前进
			else {
				for (int k = 0; k < cmd; ++k) {
					// 目标坐标
					int nx = x + dx[di];
					int ny = y + dy[di];
					
					// 能走，走一步
					int code = (( nx + 30000) << 16) +  (ny + 30000);
					if (!obstacleSet.contains(code)) {
						x = nx;
						y = ny;
						ans = Math.max(ans, x * x + y * y);
					}
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		// 25
		int[] commands = new int[] {4,-1,3};
		int[][] obstacles = new int[][] {};

		// 65
//		int[] commands = new int[] { 4, -1, 4, -2, 4 };
//		int[][] obstacles = new int[][] { { 2, 4 } };

		System.out.println(new Solution().robotSim(commands, obstacles));
	}
}