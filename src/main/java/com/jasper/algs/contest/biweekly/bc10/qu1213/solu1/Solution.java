package com.jasper.algs.contest.biweekly.bc10.qu1213.solu1;

import java.util.LinkedList;
import java.util.List;

/**
 * 1213. 三个有序数组的交集
 * 
 * <p> 遍历计数
 */
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
    	// 计数
    	int[] helper = new int[2_001];
        for(int num : arr1)
            helper[num]++;
        for(int num : arr2)
            helper[num]++;
        for(int num : arr3)
            helper[num]++;

        // 构造答案
        List<Integer> ans = new LinkedList<>();
        for(int i=1; i<2_001;i++) {
            if(helper[i]==3) {
                ans.add(i);
            }
        }
        return ans;
    }
}