package com.jasper.algs.contest.weekly.c155.qu1200.solu1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 1200. 最小绝对差
 * 
 * <p>排序 + 找最小绝对差 + 找数对
 */
class Solution {
    @SuppressWarnings("serial")
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        //找出最小绝对差
        int n = arr.length, min = arr[1]-arr[0];
        for(int i=0; i<n-1; i++) {
            min = Math.min(min, arr[i+1]-arr[i]);
        }

        //找出最小绝对差的元素对
        List<List<Integer>> ans = new LinkedList<>();
        for(int i=0; i<n-1; i++) {
            if(min == arr[i+1]-arr[i]) {
                final int low = arr[i], high = arr[i+1];
                ans.add(new ArrayList<Integer>(){{add(low); add(high);}});
            }
        }

        return ans;
    }
}