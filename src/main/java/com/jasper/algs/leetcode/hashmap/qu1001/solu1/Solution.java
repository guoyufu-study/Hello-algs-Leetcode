package com.jasper.algs.leetcode.hashmap.qu1001.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1001. 网格照明
 * 
 */
class Solution {
	
	// 灯位置 row*N+col -> true 有灯、false 无灯（已灭）
	private Map<Integer, Boolean> lampBuf = new HashMap<>();
	
	// key: 被照亮的行、列、主对角线（左上->右下）、副对角线（右上->左下）
	// value: 被照亮的次数
	private Map<Integer, Integer> rows = new HashMap<>();
	private Map<Integer, Integer> cols = new HashMap<>();
	private Map<Integer, Integer> hills = new HashMap<>(); // 主对角线：差为定值
	private Map<Integer, Integer> dales = new HashMap<>(); // 副对角线： 和为定值
	
	// 偏移量
	private int[][] cord = {
				{-1,-1}, {-1, 0}, {-1, 1},
				{0,-1}, {0, 0}, {0, 1},
				{1,-1}, {1, 0}, {1, 1},
			};
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    	
    	// 记录，并点亮
    	for (int i = 0; i < lamps.length; i++) {
    		lampBuf.put(lamps[i][0]*N + lamps[i][1], true);
			opts(lamps[i][0], lamps[i][1], 1);
    	}
    	
    	// 记录，并灭灯
    	int length = queries.length;
		int[] ans = new int[length];
    	for (int i = 0; i < length; i++) {
			ans[i] = isLighted(queries[i][0], queries[i][1]) ? 1 : 0;
			for (int j = 0; j < 9; j++) {
				int row = queries[i][0]+cord[j][0];
				int col = queries[i][1]+cord[j][1];
				if(row>=0 && row<N 
						&& col >=0 && col<N 
						&& lampBuf.getOrDefault(row*N+col, false)) {
					lampBuf.put(row*N+col, false);
					opts(row, col, -1);
				}
			}
		}
    	
    	return ans;
    }

    /**
     * 检测指定位置是否被照亮
     * 
     * @param row	行
     * @param col	列
     * @return
     */
	private boolean isLighted(int row, int col) {
		return rows.getOrDefault(row, 0)>0 || 
				cols.getOrDefault(col, 0)>0 ||
				hills.getOrDefault(row-col, 0)>0 ||
				dales.getOrDefault(row+col, 0)>0;
	}
	
	/**
	 * 操作灯
	 * 
	 * @param row	行
	 * @param col	列
	 * @param det	1 点亮  0 熄灭
	 */
	private void opts(int row, int col, int det) {
		
		rows.put(row, rows.getOrDefault(row, 0)+det);
		cols.put(col, cols.getOrDefault(col, 0)+det);
		hills.put(row-col, hills.getOrDefault(row-col, 0)+det);
		dales.put(row+col, dales.getOrDefault(row+col, 0)+det);
	}
	
	public static void main(String[] args) {
//		5
//		[[0,0],[0,1],[0,4]]
//		[[0,0],[0,1],[0,2]]

		int N = 5;
		int[][] lamps = new int[][] {{0,0},{0,1},{0,4}};
		int[][] queries = new int[][] {{0,0},{0,1},{0,2}};
		
		new Solution().gridIllumination(N, lamps, queries);
	}
}