package com.jasper.algs.leetcode.backtracing.qu0498.solu3;

/**
 * 0498. 对角线遍历
 *
 * <p>模拟遍历过程
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    	
    	// 边界处理
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        
        // 跟踪矩阵的大小
        int N = matrix.length;
        int M = matrix[0].length;
        
        // 帮助我们在矩阵中前进，一次一个元素
        int row = 0, column = 0;
        
        // 跟踪方向
        int direction = 1;
        
        // 答案数组
        int[] ans = new int[N*M];
        int r = 0;
        
        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {
            
            // First and foremost, add the current element to 
            // the result matrix. 
            ans[r++] = matrix[row][column];
            
            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if 
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);
            
            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head. 
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {
                
                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {
                    
                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0) ;
                    column += (column < M - 1 ? 1 : 0);
                        
                } else {
                    
                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }
                    
                // Flip the direction
                direction = 1 - direction;        
                        
            } else {
                
                row = new_row;
                column = new_column;
            }
        }

        
        return ans;
    }

    public static void main(String[] args) {
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		
		new Solution().findDiagonalOrder(matrix);
	}
}