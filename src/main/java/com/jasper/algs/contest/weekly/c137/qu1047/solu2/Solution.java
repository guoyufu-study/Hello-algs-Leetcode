package com.jasper.algs.contest.weekly.c137.qu1047.solu2;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * <p> 辅助栈
 */
class Solution {
    public String removeDuplicates(String S) {
        
    	StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(--sbLength);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}