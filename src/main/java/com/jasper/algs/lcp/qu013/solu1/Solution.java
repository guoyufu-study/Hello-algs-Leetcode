package com.jasper.algs.lcp.qu013.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LCP 013. 寻宝
 * 
 * <p> BFS + 动态规划
 */
class Solution {
	
	int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m;
    
	public int minimalSteps(String[] maze) {
    	
    	n = maze.length;
    	m = maze[0].length();
    	// 1. 记录特殊点
    	List<int[]> buttons = new ArrayList<int[]>();// 机关 & 石头
    	List<int[]> stones = new ArrayList<int[]>();
    	int sx = -1, sy = -1, tx = -1, ty = -1;// 起点 & 终点
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			switch (maze[i].charAt(j)) {
    			case 'M': buttons.add(new int[] {i, j}); break;
    			case 'O': stones.add(new int[] {i, j}); break;
    			case 'S': sx = i; sy = j; break;
    			case 'T': tx = i; ty = j; break;
    			}
    		}
    	}
    	
    	int nb = buttons.size();
		int ns = stones.size();
		// 起点 -> 所有位置
		int[][] startDist = bfs(sx, sy, maze);

		// 无机关：起点 -> 终点
		if(nb==0) return startDist[tx][ty];
		
		// 2. 动态规划 ： 所有机关 -> 其他机关、起点、终点
		int[][] dist = new int[nb][nb+2];
		for(int i=0; i<nb; i++) Arrays.fill(dist[i], -1);
		
		// 中间结果：所有机关 -> 所有位置 
		int[][][] dd = new int[nb][][];
		for (int i = 0; i < nb; i++) {
			// 某机关 -> 所有位置
			int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
			dd[i] = d;
		}
		
		// 所有机关 -> 石堆 -> 其它机关、起点、终点
		for (int i = 0; i < nb; i++) {
			// 机关 -> 石堆 -> 机关
			for (int j = i+1; j < nb; j++) {
				int mn = -1;
				for (int k = 0; k < ns; k++) {// 遍历石堆
					int midX = stones.get(k)[0], midY = stones.get(k)[1]; // 石堆
					if(dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1) {// 可达
						if(mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY]) {// 更新值
							mn = dd[i][midX][midY] + dd[j][midX][midY];
						}
					}
				}
				dist[i][j] = dist[j][i] = mn;
			}
			
			// 机关 -> 石堆 -> 起点
			int tmp = -1;
			for (int k = 0; k < ns; k++) {// 遍历石堆
				int midX = stones.get(k)[0], midY = stones.get(k)[1]; // 石堆
				if(dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {// 可达
					if(tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {// 更新值
						tmp = dd[i][midX][midY] + startDist[midX][midY];
					}
				}
			}
			dist[i][nb] = tmp;
			
			// 机关 -> 终点 : 不需要拿石头
			dist[i][nb+1] = dd[i][tx][ty];
		}
		
		// 有机关不可达
		for (int i = 0; i < nb; i++) 
			if(dist[i][nb]==-1 || dist[i][nb+1]==-1)
				return -1;
		
		// 3. 动态规划 (mask, i) 触发 i 机关后，得到 mask 掩码
		int[][] dp = new int[1<<nb][nb];
		// 未触发机关
		for (int i = 0; i < 1<<nb; i++) Arrays.fill(dp[i], -1); 
		// 触发第一个机关
		for (int i = 0; i < nb; i++) dp[1<<i][i] = dist[i][nb]; 
		// 触发其它机关
		for (int mask = 1; mask < (1 << nb); mask++) {
			// 最后一步触发了 i 机关
			for (int i = 0; i < nb; i++) {
				int last = mask | (1 << i);
                if (last != mask)  continue;
                // 现在触发 j 机关
                for (int j = 0; j < nb; j++) {
                	int next = mask | (1 << j);
                    if (next == mask) continue;
                    if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) // 更新
                        dp[next][j] = dp[mask][i] + dist[i][j];
                }
                
            }
		}
		
		// 最后一个机关 -> 终点
		int ret = -1;
        int final_mask = (1 << nb) - 1;
        for (int i = 0; i < nb; i++) {
            if (ret == -1 || ret > dp[final_mask][i] + dist[i][nb + 1]) {
                ret = dp[final_mask][i] + dist[i][nb + 1];
            }
        }
		return ret;
    }

	/**
	 * 求 [(x,y) -> 所位位置] 最短距离
	 */
	private int[][] bfs(int x, int y, String[] maze) {
		int[][] ret = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(ret[i], -1);
		}
		
		ret[x][y] = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {x, y});
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			int currx = p[0], curry = p[1];
			for (int k = 0; k < 4; k++) {
				int nx = currx + dx[k], ny = curry + dy[k];
				if(inBound(nx, ny) && maze[nx].charAt(ny)!='#' && ret[nx][ny] == -1) {// 边界内，非墙，未经过
					ret[nx][ny] = ret[currx][curry] + 1;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
		return ret;
	}

	/**
	 * 是否越界
	 */
	private boolean inBound(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}