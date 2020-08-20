package com.jasper.algs.leetcode.dp.qu0085.solu1;

/**
 * 暴力求解（简单优化）
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length==0) return 0;
    	
    	int ans = 0;
    	int rows=matrix.length, cols=matrix[0].length;//行列
    	
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {//定位左上顶点
				if(matrix[i][j]=='0') continue;
				
				// 计算能得出的最大矩形面积
				int maxLen=0, maxHeight=Integer.MAX_VALUE;
				// 向右延伸，长度逐渐增大，
				for (int k = j; k < cols; k++) {
					if(matrix[i][k]=='0') break;
					maxLen++;
					
					// 长度固定，向下延伸，确定高度
					int tmpHeiht = 1;
					for (int m = i+1; m < rows; m++) {
						if(matrix[m][k]=='0') break;
						tmpHeiht++;
					}
					maxHeight = Math.min(maxHeight, tmpHeiht);
					
					// 更新记录最大矩形面积：矩形面积 = 长度 * 高度
					ans = Math.max(ans, maxLen * maxHeight);
				}
				
			}
		}
    	
    	return ans;
    }
}