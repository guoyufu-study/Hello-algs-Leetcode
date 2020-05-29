package com.jasper.algs.leetcode.greedy.qu1417.solu2;

/**
 * 1417. 重新格式化字符串
 * 
 * <p> 双指针
 */
class Solution {
    public String reformat(String s) {

StringBuilder ans = new StringBuilder();//答案
    	
    	// 计算长度
    	int cn = 0;
    	int nn = 0;
    	for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)<='9')
				nn++;
			else cn++;
		}
    	if(cn>nn+1 || nn>cn+1) return ans.toString();//无法按要求重新格式化
    	
    	int cp = 0;//双指针
    	int np = 0;
    	while(np<s.length() && cp<s.length()) {
			while(np<s.length() && s.charAt(np)>='a') np++;// 指向下一个数字
    		while(cp<s.length() && s.charAt(cp)<='9') cp++;//指向下一个字母
    		
    		if(!(np<s.length() && cp<s.length())) break;
    		
    		char first = (cn == nn+1)?s.charAt(cp):s.charAt(np);
    		char second = (cn == nn+1)?s.charAt(np):s.charAt(cp);
    		
    		ans.append(first).append(second);
    		np++;
    		cp++;
		}
    	
    	if(nn == cn+1) ans.append(s.charAt(np));
    	if(cn == nn+1) ans.append(s.charAt(cp));
    	
    	
    	return ans.toString();
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