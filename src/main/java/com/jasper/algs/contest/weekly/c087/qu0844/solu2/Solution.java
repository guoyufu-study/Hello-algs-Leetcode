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

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
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