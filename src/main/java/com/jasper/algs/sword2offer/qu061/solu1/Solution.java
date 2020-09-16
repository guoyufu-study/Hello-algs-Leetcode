package com.jasper.algs.sword2offer.qu061.solu1;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 
 * <p> 辅助字典
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int max=0, min=13;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(num==0) continue; // 跳过 jacker, 数量不限于 2
            if(set.contains(num)) return false;// 重复
            
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max-min<5; // 长度低于 5
    }
}