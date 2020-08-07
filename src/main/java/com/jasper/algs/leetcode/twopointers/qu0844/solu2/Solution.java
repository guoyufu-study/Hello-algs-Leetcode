package com.jasper.algs.leetcode.twopointers.qu0844.solu2;

/**
 * 0844. 比较含退格的字符串
 *
 * <p> 双指针
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1, j = T.length()-1;
        i = getValidIndex(S, i);
    	j = getValidIndex(T, j);
        while(i>=0 && j>=0) {
        	if(i>=0 && j>=0) {
        		if(S.charAt(i)!=T.charAt(j))
        			return false;
        		i--;
        		j--;
        	}
        	
        	i = getValidIndex(S, i);
        	j = getValidIndex(T, j);
        }
        
    	return i<0 && j<0 ? true : false;
    }
    
    private int getValidIndex(String S, int i) {
    	int count = 0;
    	while(i>=0 && (count>0 || S.charAt(i)=='#')) {
    		if(S.charAt(i)=='#')
    			count++;
    		else 
    			count--;
    		
    		i--;
    	}
    	
		return i;
	}

	public static void main(String[] args) {
    	// true
//    	String S = "ab#c";
//    	String T = "ad#c";
    	
    	// true
//    	String S = "ab##";
//    	String T = "c#d#";
    	
    	// true
//    	String S = "a##c";
//    	String T = "#a#c";
    	
    	// false
//    	String S = "a#c";
//    	String T = "b";
    	
    	// true
    	String S = "nzp#o#g";
    	String T = "b#nzp#o#g";
    	
    	
    	System.out.println(new Solution().backspaceCompare(S, T));
	}
}