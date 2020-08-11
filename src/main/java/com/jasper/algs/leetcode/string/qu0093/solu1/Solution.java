package com.jasper.algs.leetcode.string.qu0093.solu1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0093. 复原IP地址
 * 
 * <p> 暴力枚举
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        
        ArrayList<String> ans = new ArrayList<String>();
        StringBuilder ip = new StringBuilder();
        for (int a = 1; a < 4; a++) {
        	for (int b = 1; b < 4; b++) {
        		for (int c = 1; c < 4; c++) {
        			/*
                     * 1、保障下面subString不会越界
                     * 2、保障截取的字符串与输入字符串长度相同
                     * //1、2比较好理解，3比较有意思
                     * 3、不能保障截取的字符串转成int后与输入字符串长度相同
                     * 如：字符串010010，a=1，b=1，c=1，d=3，对应字符串0，1，0，010
                     * 转成int后seg1=0，seg2=1，seg3=0，seg4=10
                     * //所以需要下面这处判断if (ip.length() == s.length() + 3)
                     */
					int d = n - a - b - c;
					if(d > 0 && d < 4) {
						 int n1 = Integer.parseInt(s.substring(0, a));
                         int n2 = Integer.parseInt(s.substring(a, a+b));
                         int n3 = Integer.parseInt(s.substring(a+b, a+b+c));
                         int n4 = Integer.parseInt(s.substring(a+b+c));
                         
                         // 四个段数值满足0~255
                         if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255)
                         {
                             ip.append(n1).append('.').append(n2)
                                     .append('.').append(n3).append('.').append(n4);
                             
                             // 保障截取的字符串转成int后与输入字符串长度相同
                             if(ip.length() == s.length() + 3) ans.add(ip.toString());
                             
                             ip.delete(0, ip.length());
                         }
					}
				}
				
			}
			
		}
    	return ans;
    }
}