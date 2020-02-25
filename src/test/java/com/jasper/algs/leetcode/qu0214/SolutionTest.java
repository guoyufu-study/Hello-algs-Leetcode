package com.jasper.algs.leetcode.qu0214;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		",''",
		"'',''",
		"aacecaaa,aaacecaaa",
		"abcd,dcbabcd",
		"a,a"
	})
	void testShortestPalindrome1(String s, String expected) {
		String palindrome = new com.jasper.algs.leetcode.qu0214.solu1.Solution()
				.shortestPalindrome(s);
		assertThat(palindrome).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@CsvSource({
		",''",
		"'',''",
		"aacecaaa,aaacecaaa",
		"abcd,dcbabcd",
		"a,a"
	})
	void testShortestPalindrome2(String s, String expected) {
		String palindrome = new com.jasper.algs.leetcode.qu0214.solu2.Solution()
				.shortestPalindrome(s);
		assertThat(palindrome).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@CsvSource({
		",''",
		"'',''",
		"aacecaaa,aaacecaaa",
		"abcd,dcbabcd",
		"a,a"
	})
	void testShortestPalindrome22(String s, String expected) {
		String palindrome = new com.jasper.algs.leetcode.qu0214.solu2.Solution2()
				.shortestPalindrome(s);
		assertThat(palindrome).isEqualTo(expected);
	}

}
