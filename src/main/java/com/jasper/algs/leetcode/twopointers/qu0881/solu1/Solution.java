package com.jasper.algs.leetcode.twopointers.qu0881.solu1;

import java.util.Arrays;

/**
 * 0881. 救生艇
 * 
 * <p> 贪心 + 排序 + 双指针
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);

        int n = people.length, left = 0, right = n-1;
        int ans = 0;
        while(left<=right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            ans++;
        }

        return ans;
    }
}