package com.jasper.algs.summary.stringmatching;

public class KMP {

	// KMP 搜索
	public void kmpSearch(String text, String pattern) {
		int[] prefixTable = longestCommonPrefixSuffix(pattern);
		
		int m = text.length();
		int n = pattern.length();
		int i = 0, j = 0;
		while(i<m) {
			if(j==n-1 && text.charAt(i)==pattern.charAt(j)) {
				// 成功找到
				System.out.printf("Found pattern at %d%n", i-j);
				
				// 继续找下一个
				j = prefixTable[j];//按失配算
				if(j==-1) {
					i++;
					j++;
				}
//				return i-j;
			}
			if(text.charAt(i)==pattern.charAt(j)) {//匹配
				i++;
				j++;
			} else {//失配
				j = prefixTable[j]; // 更新 j
				if(j==-1) {
					i++;
					j++;
				}
			}
			
		}
		System.out.println("NOT Found!!!");
//		return -1;
	}
	
	// 构造前缀表：最长公共前后缀
	public int[] longestCommonPrefixSuffix(String pattern) {
		int[] prefixTable = new int[pattern.length()];
		
		prefixTable[0] = 0;
		int len = 0;//最长公共前后缀的长度
		int i = 1;
		while(i<pattern.length()) {
			if( pattern.charAt(i) == pattern.charAt(len)) {
				prefixTable[i] = ++len;
				i++;
			} else {
				if(len>0)
					len = prefixTable[len-1];
				else {
					prefixTable[i] = len;
					i++;
				}
			}
		}
		
		// 统一后移一位
		for (int j = prefixTable.length-1; j > 0; j--) {
			prefixTable[j] = prefixTable[j-1];
		}
		prefixTable[0] = -1;
		return prefixTable;
	}
	
	public static void main(String[] args) {
		String text = "ABABABCABAABABCABAAABABCABAA";
		String pattern = "ABABCABAA";
		
		new KMP().kmpSearch(text, pattern);
		
//		Arrays.stream(new KMP().longestCommonPrefixSuffix(pattern))
//			.forEach(System.out::println);
		
	}
}
