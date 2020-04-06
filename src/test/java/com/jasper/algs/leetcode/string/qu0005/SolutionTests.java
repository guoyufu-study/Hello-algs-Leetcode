package com.jasper.algs.leetcode.string.qu0005;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class SolutionTests {
	
	@ParameterizedTest
	@CsvSource(value = {
		"N/A,''", "nil,''", ",''",//null
		"'',''",//空字串
		"a,a",
		"bb,bb",
		"babad,aba", //奇数
		"cbbd,bb", //偶数
		"abacdfgdcaba,aba"
	}, nullValues = {"N/A","nil"})
	void testLongestPalindrome(String s, String extended) {
		String palindrome = new com.jasper.algs.leetcode.string.qu0005.solu4.Solution()
				.longestPalindrome(s);
		assertThat(palindrome).isEqualTo(extended);
	}
	
}
