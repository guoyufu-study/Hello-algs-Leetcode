package com.jasper.algs.interview.qu0105.solu2;

/**
 * 面试题 01.05. 一次编辑
 * 
 * <p> 左右指针
 */
class Solution {
    public boolean oneEditAway(String first, String second) {
        if(Math.abs(first.length() - second.length()) > 1)
            return false;
            
        int st1 = 0, st2 = 0;
        int end1 = first.length()-1, end2 = second.length()-1;

        while(st1 < first.length() && st2 <second.length()){
            if(first.charAt(st1) == second.charAt(st2)){
                st1++;
                st2++;
            }else break;
        }

        while(end1 >= 0 && end2 >= 0){
            if(first.charAt(end1) == second.charAt(end2)){
                end1--;
                end2--;
            }else break;
        }
        
        return end1 - st1 < 1 && end2 - st2 < 1;
    }
}