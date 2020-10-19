package com.jasper.algs.contest.weekly.c087.qu0846.solu2;

import java.util.Arrays;

/**
 * 0846. 一手顺子
 * 
 * <p> 排序 + 标记浏览
 */
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0)return false;
        Arrays.sort(hand);
        int count = 1;
        for(int i=0;i<hand.length;i++){
            if(hand[i] == -1)continue;
            count=1;
            for(int j=i+1;j<hand.length && count<W;j++){
                if(hand[j] == hand[i]+count){
                    hand[j] = -1;
                    count++;
                }else if(hand[j]<hand[i]+count)continue;
                else return false;
            }
            if(count!= W)return false;
            hand[i] = -1;
        }
        return true;
    }
}