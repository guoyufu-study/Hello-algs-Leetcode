package com.jasper.algs.contest.weekly.c193.qu1482.solu1;

/**
 * 1482. 制作 m 束花所需的最少天数
 * 
 * <p> 二分查找
 */
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int maxDay = 0, minDay = 1000000000;
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            maxDay = maxDay >= bloomDay[i] ? maxDay : bloomDay[i];
            minDay = minDay <= bloomDay[i] ? minDay : bloomDay[i];
        }

        int midDay;
        while (minDay < maxDay) {
            midDay = (maxDay + minDay) / 2;
            if (getCanMakeBouquetsCount(bloomDay, m, k, midDay) >= m) {
                maxDay = midDay;
            } else {
                minDay = midDay + 1;
            }
        }
        return minDay;
    }

    private int getCanMakeBouquetsCount(int[] bloomDay, int m, int k, int day) {
        int preFlowerDay = -1;
        int BouquetsCount = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] > day) {
                BouquetsCount += (i - preFlowerDay - 1) / k;
                preFlowerDay = i;
                if (BouquetsCount >= m || n - i < (m - BouquetsCount) * k) {
                    return BouquetsCount;
                }
            }
            
        }
        BouquetsCount += (n - preFlowerDay - 1) / k;
        return BouquetsCount;
    }
}