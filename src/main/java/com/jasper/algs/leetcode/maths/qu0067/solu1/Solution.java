package com.jasper.algs.leetcode.maths.qu0067.solu1;

/**
 * 模拟两数相加（暴力）
 */
class Solution {
    public String addBinary(String a, String b) {
    	int la = a.length(),lb = b.length();
    	int lans = Math.max(la, lb)+1;
        char[] ans = new char[lans];
        ans[lans-1] = '0';
        
        int ap = la-1;// 指针
        int bp = lb-1;
        int ansp = lans -1;
        
        while(ap>=0 || bp >=0) {
        	int digit = (ap>=0?a.charAt(ap):'0')  -
        			'0' + 
        			(bp>=0?b.charAt(bp):'0');
            ans[ansp] += (char) digit - '0';
            ans[ansp-1]+='0';
    		if(ans[ansp]>'1') {
    			ans[ansp-1]++;//进位
    			ans[ansp]-=2;
    		} 
    		ap--;
    		bp--;
    		ansp--;
        }
        	
        if(ans[0]=='0') return new String(ans, 1, lans-1);
        return new String(ans);
    }
    
    public static void main(String[] args) {
    	String a = "11";
    	String b = "1";
    	
    	new Solution().addBinary(a, b);
	}
}