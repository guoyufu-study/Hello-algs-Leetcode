package com.jasper.algs.contest.weekly.c156.qu1210.solu1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1210. 穿过迷宫的最少移动次数
 * 
 * <p> BFS
 */
class Solution {
    public int minimumMoves(int[][] grid) {
    	
    	Deque<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0, 0, 0, 1});
		grid[0][1] += 2;// 0 未经过、1 不允许经过、2 水平经过、3 垂直经过
		int n = grid.length, ans = -1;
		while(!queue.isEmpty()) {
			ans++;
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int[] tmp = queue.poll();
				int tr = tmp[0], tc = tmp[1], hr = tmp[2], hc = tmp[3];
				if(tr==n-1 && tc==n-2 && hr==n-1 && hc==n-1) { // 到达终点
					return ans;
				}
				
				// 当前方向
				if(tr==hr) {// 水平方向
					if(hc+1 < n && grid[hr][hc+1]!=1) {// 水平向右
                        if(grid[hr][hc+1]==0 || grid[hr][hc+1]==3) {
                            queue.add(new int[] {hr, hc, hr, hc+1});
							grid[hr][hc+1] += 2;// 标记水平经过
                        }
							
					}
					
                    if(tr+1<n && hr+1 < n && grid[tr+1][tc]!=1 && grid[hr+1][hc]!=1) {
						if(grid[tr+1][tc]==0 || grid[tr+1][tc]==2) {// 水平转垂直
							queue.add(new int[] {tr, tc, tr+1, tc});
							grid[tr+1][tc] += 3;// 垂直
						}
						if(grid[hr+1][hc]==0 || grid[hr+1][hc]==3) {// 水平向下
							queue.add(new int[] {tr+1, tc, hr+1, hc});
							grid[hr+1][hc] += 2;
						}
					}
				} else {// 垂直方向
					if(hr+1<n && grid[hr+1][hc]!=1) {// 垂直向下
                        if(grid[hr+1][hc]==0 || grid[hr+1][hc]==2) {
                            queue.add(new int[] {hr, hc, hr+1, hc});
						    grid[hr+1][hc] += 3;
                        }
						
					}
                    if(hc+1 <n && tc+1<n && grid[hr][hc+1]!=1 && grid[tr][tc+1]!=1) {
						if(grid[hr][hc+1]==0 || grid[hr][hc+1]==2) {// 垂直向右
							queue.add(new int[] {tr, tc+1, hr, hc+1});
							grid[hr][hc+1] += 3;
						}
						if(grid[tr][tc+1]==0 || grid[tr][tc+1]==3) {// 垂直转水平
							queue.add(new int[] {tr, tc, tr, tc+1});
							grid[tr][tc+1] += 2;
						}
					} 
				}
					
			}
		}
		return -1;
	}
}