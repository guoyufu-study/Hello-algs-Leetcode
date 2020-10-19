package com.jasper.algs.contest.weekly.c087.qu0846.solu1;

import java.util.Map;
import java.util.TreeMap;

/**
 * 0846. 一手顺子
 * 
 * <p> 辅助字典（TreeMap）
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n%W!=0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : hand) {
            map.compute(num, (k, v) -> v==null ? 1 : v+1);
        }
        
        
        while(map.size()>0) {
            int len = 0;
            Map.Entry<Integer, Integer> first = map.firstEntry();
            int key = first.getKey(), count = first.getValue();
            while(len < W) {
                int tmp = map.getOrDefault(key, -1);
                if(tmp<count) return false;
                if(tmp==count) map.remove(key);
                else map.compute(key, (k, v) -> v-count);
                len++;
                key++;
            }
        }

        return true;
    }
}