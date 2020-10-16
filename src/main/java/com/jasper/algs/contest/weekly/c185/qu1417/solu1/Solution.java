package com.jasper.algs.contest.weekly.c185.qu1417.solu1;

/**
 * 1417. 重新格式化字符串
 * 
 * <p> 贪心算法
 */
class Solution {
    public String reformat(String s) {

    	int count = s.length();
    	// 边界：两个字母
    	if(count==2 && !isNumberic(s.charAt(0)) && !isNumberic(s.charAt(0))) 
    		return "";
    	
		int[] ans = new int[count+1];
    	int offset = 1;
    	
    	// 贪心选择
    	int i = 1; // 数字
    	int j = 2; // 字母
    	for (char c : s.toCharArray()) {
    		// 贪心选择位置
    		if(isNumberic(c)) {
    			// 边界
        		if(i>count) return "";
        		
    			ans[i] = c;
        		i+=2;
    		} else {
    			// 边界
    			if(j>count) 
        			if(ans[0]==0) {
        				ans[0] = c;
        				offset = 0;
        			}
        			else return "";
    			else {
    				ans[j] = c;
        			j+=2;
    			}
    		}
		}
    	
    	return new String(ans, offset, count);
    }
    
    private boolean isNumberic(char c) {
    	return c>='0' && c<='9';
    }
    
    public static void main(String[] args) {
		
    	// 0a1b2c
//    	String s = "a0b1c2";
		
    	// 空字串
//    	String s = "leetcode";
    	
    	// 空字串
//    	String s = "1229857369";
    	
    	// 
//    	String s = "covid2019";
    	
    	// 1a2b3
//    	String s = "ab123";
    	
    	// a
//    	String s = "a";
    	// 2
//    	String s = "2";
    	
    	// 空字串
//    	String s = "ab";
    	// 空字串
    	String s = "12";
    	
		System.out.println(new Solution().reformat(s));
    	
	}
}