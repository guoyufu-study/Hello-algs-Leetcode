package com.jasper.algs.leetcode.hashmap.qu0299.solu2;

/**
 * 0299. 猜数字游戏
 * 
 * <p> 辅助字典
 */
class Solution {
    public String getHint(String secret, String guess) {
    	int[] hash = new int[10];
        int x = 0, y = 0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)== guess.charAt(i)){
                x++;
            } else {
            	hash[secret.charAt(i) - '0']++;
                hash[guess.charAt(i) - '0']--;
            }
        }
        //计算hash中正值的个数
        for(int i=0;i<10;i++){
            if(hash[i] > 0) y += hash[i];
        }
        
        y = secret.length() - y - x;
        return x + "A" + y + "B";
    }
}