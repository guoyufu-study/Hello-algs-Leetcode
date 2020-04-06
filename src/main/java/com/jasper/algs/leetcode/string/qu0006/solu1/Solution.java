package com.jasper.algs.leetcode.string.qu0006.solu1;

public class Solution {

	public String convert(String s, int numRows) {
		if(numRows==1) return s;
		
		int len = s.length(),
			cycleLen = 2*numRows-2,//循环长度
			index=0;//原字符串中位置索引
		
		StringBuilder ans = new StringBuilder();
		for (int k = 0; k < numRows; k++) {//k=行号
			for (int j = 0; j+k < len; j+=cycleLen) {//j=首行字母索引
				index = j+k;//竖列
				ans.append(s.charAt(index));
				
				index = j+cycleLen-k;//斜线
				if(k!=0 && k!=numRows-1 && index<len)
						ans.append(s.charAt(index));
			}
		}
		
		return ans.toString();
    }
}
