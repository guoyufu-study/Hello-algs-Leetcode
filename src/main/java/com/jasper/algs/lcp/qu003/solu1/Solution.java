package com.jasper.algs.lcp.qu003.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * LCP 03. 机器人大冒险
 * 
 * <p> 找模式 + 辅助字典
 */
class Solution {
	public boolean robot(String command, int[][] obstacles, int x, int y) {

		// 多次循环 找到模式
		// 学到了新的存储坐标的方法 左坐标左移30 | 右坐标
		int xx = 0, yy = 0;
		Set<Long> ss = new HashSet<>();
		ss.add(((long) xx << 30) | yy);
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'U') {
				yy++;
			} else {
				xx++;
			}
			ss.add(((long) xx << 30) | yy);
		}

		// 终点不在路径上
		int cir = Math.min(x / xx, y / yy);
		if (!ss.contains(((long) (x - cir * xx) << 30) | (y - cir * yy))) {
			return false;
		}

		for (int[] s : obstacles) {
			// 障碍点在终点之外
			int x1 = s[0];
			int y1 = s[1];
			if (x1 > x || y1 > y)
				continue;
			// 障碍点在路径上
			cir = Math.min(x1 / xx, y1 / yy);
			if (ss.contains(((long) (x1 - cir * xx) << 30) | (y1 - cir * yy))) {
				return false;
			}
		}
		
		return true;
	}
}