package com.jasper.algs.leetcode.greedy.qu0012.solu1;

/**
 * 0012. 整数转罗马数字
 * 
 * <p> 查字典
 */
class Solution {
	
	private static final String[][] dic_orgi;
	private static final String[][] dic;
	
	static {
		dic_orgi = new String[][] {
	        	{"I","V"},
	        	{"X","L"},
	        	{"C","D"},
	        	{"M",""},
        	};
        
        // 构造字典
    	int limit = 3999;
        int len = 0;
		while((limit=limit/10)!=0) len ++;// len=3
        dic = new String[len+1][10];
        for (int i = 0; i < len; i++) {
        	dic[i][0] = "";
			dic[i][1] = dic_orgi[i][0];
			dic[i][2] = dic[i][1]+dic_orgi[i][0];
			dic[i][3] = dic[i][2]+dic_orgi[i][0];
			
			dic[i][5] = dic_orgi[i][1];
			dic[i][4] = dic_orgi[i][0]+dic[i][5];
			dic[i][6] = dic[i][5]+dic_orgi[i][0];
			dic[i][7] = dic[i][6]+dic_orgi[i][0];
			dic[i][8] = dic[i][7]+dic_orgi[i][0];
			
			
			dic[i][9] = dic_orgi[i][0]+dic_orgi[i+1][0];
        }
		
		dic[len][1] = dic_orgi[len][0];
		dic[len][2] = dic[len][1]+dic_orgi[len][0];
		dic[len][3] = dic[len][2]+dic_orgi[len][0];
	}
	
    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        
        int count = 0, tmp = num;
        while((tmp=tmp/10)!=0) count++;
		
        while(num != 0) {
        	int pow = (int)Math.pow(10, count);
			int digit = num/pow;
        	
        	ans.append(dic[count][digit]);
        	
        	num -= digit * pow;
        	count--;
        }
		
		return ans.toString();
    
    }
    
    
    public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(9));
	}
}