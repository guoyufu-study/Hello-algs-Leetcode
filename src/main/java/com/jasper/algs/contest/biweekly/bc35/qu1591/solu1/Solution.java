package com.jasper.algs.contest.biweekly.bc35.qu1591.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1591. 奇怪的打印机 II
 * 
 * <p> 构图拓朴排序
 */
class Solution {
    // 建立有向图，对每个颜色建立边
    // 图必须存在拓扑排序，即一个颜色必须在另一个颜色之后进行染色
    public boolean isPrintable(int[][] targetGrid) {
        int rows= targetGrid.length, cols = targetGrid[0].length;

        // 初始化每个颜色矩阵的边界
        int[] top= new int[61],bottom= new int[61],left= new int[61],right = new int[61];
        Arrays.fill(top,61);
        Arrays.fill(left,61);
        Arrays.fill(bottom,-1);
        Arrays.fill(right,-1);
        int color = 0;
        // 建立每个颜色的矩阵边界
        for(int i=0;i<rows;i++){
            for(int j=0; j<cols; j++){
                color = targetGrid[i][j];
                top[color] = Math.min(top[color], i);
                bottom[color] = Math.max(bottom[color], i);
                left[color] = Math.min(left[color], j);
                right[color] = Math.max(right[color], j);
            }
        }

        // 根据矩阵建立有向图，遍历targetGrid，
        // 当前位置颜色X在某个矩阵A中但是不为矩阵A的颜色时，建立从A到X的边
        // X可以存在于多个矩阵中
        // 变量：是否存在边-防止重复建立边；入度，便于后期判断是否拓扑排序；邻接表，从i出发到达的点
        boolean[][] hasEdge= new boolean[61][61];
        int[] inDegree = new int[61];
        List<List<Integer>> adjs = new ArrayList<>();
        for(int i=0;i<=60;i++){
            adjs.add(new ArrayList<Integer>());
        }
        int curColor = 0;
        // 建立图
        for(int i=0;i<rows;i++){
            for(int j=0; j<cols; j++){
                curColor = targetGrid[i][j];
                for(color=1; color<=60; color++){
                    if(i>=top[color] && i<=bottom[color] && j>=left[color] && j<=right[color])
                        if(curColor!=color && !hasEdge[color][curColor]){
                            adjs.get(color).add(curColor);
                            inDegree[curColor]++;
                            hasEdge[color][curColor] = true;
                        }
                }
            }
        }

        // 寻找入度为0的颜色点，减小该点连结的点的入度，直到所有点的入度都为0
        ArrayList<Integer> zeroC = new ArrayList<>();

        while(true){
            int i;
            for(i=1;i<=60;i++){
                if(inDegree[i]==0){
                    zeroC.add(i);
                    for(Integer pointTo:adjs.get(i)){
                        inDegree[pointTo]--;
                    }
                    inDegree[i]=-1;
                    break;
                }
            }
            if(i==61)break;
        }
        return zeroC.size()==60;

    }
}