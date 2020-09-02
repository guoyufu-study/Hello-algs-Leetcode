package com.jasper.algs.leetcode.string.qu0466.solu1;

import java.util.HashMap;
import java.util.Map;

/**
 * 0466. 统计重复个数
 * 
 * <p> 找出循环节
 */
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    	int len1 = s1.length(), len2 = s2.length();
    	// s2 在 S1 中的循环节
    	Map<Integer,int[]> map = new HashMap<Integer, int[]>();
    	int index = 0, s1cnt = 0, s2cnt = 0;
    	int[] preLoop, inLoop;
    	while(true) {
    		// 遍历一个 s1
    		for(int i=0; i<len1; i++) {
				if(s2.charAt(index)==s1.charAt(i)) {// 同步匹配s2
					index++;
					if(index==len2) {
						s2cnt++;
						index = 0;
					}
				}
    		}
    		
    		// 结束：未找到循环节
    		if(++s1cnt == n1) {
    			return s2cnt / n2;
    		}
    		
    		// 记录
    		if(!map.containsKey(index))
    			map.put(index, new int[] {s1cnt, s2cnt});
    		else {
    			preLoop = map.get(index);
    			inLoop = new int[] {s1cnt-preLoop[0], s2cnt-preLoop[1]};
    			break;
    		}
    	}
    	
    	// s2 在 S1 中的个数
    	int ans = preLoop[1] + (n1-preLoop[0])/inLoop[0] * inLoop[1];
    	int rest = (n1 - preLoop[0]) % inLoop[0]; // 剩余s1个数
    	for (int i = 0; i < rest; i++) { // 剩余 s1 中s2的个数
    		for(int j=0; j<len1; j++) {
				if(s2.charAt(index)==s1.charAt(j)) {
					index++; // index 继续，而不是从0开始
					if(index==len2) {
						ans++;
						index = 0;
					}
				}
    		}
		}
    	return ans / n2;
    }
}