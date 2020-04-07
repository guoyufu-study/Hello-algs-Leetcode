package com.jasper.algs.leetcode.twopointers.qu0003;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTests {

	@ParameterizedTest
	@MethodSource("createListNodes")
	public void testLengthOfLongestSubstring2(String s, int result) {
		assertThat(result).isEqualTo(new com.jasper.algs.leetcode.twopointers.qu0003.solu2.Solution().lengthOfLongestSubstring(s));
	}
	
	@ParameterizedTest
	@MethodSource("createListNodes")
	public void testLengthOfLongestSubstring3(String s, int result) {
		assertThat(result).isEqualTo(new com.jasper.algs.leetcode.twopointers.qu0003.solu3.Solution().lengthOfLongestSubstring(s));
	}
	
	static Stream<Arguments> createListNodes() {
		return Stream.of(
				arguments("abcabcbb", 3),
				arguments("bbbbb", 1),
				arguments("pwwkew", 3),
				arguments("tmmzuxt", 5)
				);
	}
}
