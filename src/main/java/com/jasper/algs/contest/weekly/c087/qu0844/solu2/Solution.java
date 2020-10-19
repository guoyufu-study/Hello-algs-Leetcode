package com.jasper.algs.contest.weekly.c087.qu0844.solu2;

/**
 * 0844. 比较含退格的字符串
 *
 * <p> 双指针
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
    	int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while(i>=0 || j>=0) {
            while(i>=0) {
                if(S.charAt(i)=='#') skipS++;
                else if(skipS>0) skipS--;
                else break;
                i--;
            }

            while(j>=0) {
                if(T.charAt(j)=='#') skipT++;
                else if(skipT>0) skipT--;
                else break;
                j--;
            }

            if(i<0 && j<0) return true;
            if(i<0 || j<0 || S.charAt(i)!=T.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
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