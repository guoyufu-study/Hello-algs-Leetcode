package com.jasper.algs.leetcode.hashmap.qu0299.solu1;

/**
 * 0299. 猜数字游戏
 * 
 * <p> 辅助字典
 */
class Solution {
    public String getHint(String secret, String guess) {
    	int n = secret.length(), x = 0, y = 0;
    	int[] hash = new int[10];
    	for (int i = 0; i < n; i++) {
			if(secret.charAt(i) == guess.charAt(i)) 
				x++;
			else {
                if(hash[guess.charAt(i)-'0']-- > 0) y++;
                if(hash[secret.charAt(i)-'0']++ < 0) y++;
            }
		}
    	return x+"A"+y+"B";
    }
}