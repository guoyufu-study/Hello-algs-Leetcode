package com.jasper.algs.leetcode.twopointers.qu0076.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 0076.最小覆盖子串
 * 
 * <p> 滑动窗口+辅助字典
 */
class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
         Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) 
             map.compute(c, (k,v)->v==null?1:v+1);

         Map<Character, Integer> tmp = new HashMap<>();
        int count = 0, len = Integer.MAX_VALUE, L = 0, R = -1;
        for(int left=0, right=0; left+m<=n && right<n; right++) {
            char c = s.charAt(right);
             if(!map.containsKey(c)) continue;
             tmp.compute(c, (k,v)->v==null?1:v+1);
             if(tmp.get(c).intValue() == map.get(c).intValue()) count++;
             while(count == map.size()) {
                c = s.charAt(left);
                ++left;
                 if(!map.containsKey(c)) continue;
                 if(tmp.get(c).intValue() == map.get(c).intValue()) {
                    count--;
                    if(len > right-left+2) {
                        L = left-1;
                        R = right+1;
                        len = R-L;
                    }
                }
                 tmp.compute(c, (k,v)->v==1?null:v-1);
            }
        }

        return R==-1?"":s.substring(L,R);
    }
}