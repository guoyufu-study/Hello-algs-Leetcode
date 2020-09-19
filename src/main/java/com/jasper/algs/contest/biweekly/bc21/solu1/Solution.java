package com.jasper.algs.contest.biweekly.bc21.solu1;

/**
 * 1371. 每个元音包含偶数次的最长子字符串
 * 
 * <p> 前缀奇偶性 + 状态压缩
 */
class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length(), ans = 0, status = 0;
        int[] pos = new int[32];
        pos[0] = 1;
        for(int i=0; i<n; i++) {
            switch (s.charAt(i)) {
                case 'a':
                    status ^= 1;
                    break; //与00001异或
                case 'e':
                    status ^= 2;
                    break; //与00010异或
                case 'i':
                    status ^= 4;
                    break; //与00100异或
                case 'o':
                    status ^= 8;
                    break; //与01000异或
                case 'u':
                    status ^= 16;
                    break; //与10000异或
                default:
                    break;
            }
            if(pos[status]>=1) 
                ans = Math.max(ans, i+2 - pos[status]);
            else 
                pos[status] = i+2;
        }

        return ans;
    }
}