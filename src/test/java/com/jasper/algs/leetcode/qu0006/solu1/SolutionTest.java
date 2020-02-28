package com.jasper.algs.leetcode.qu0006.solu1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testConvert(String s, int numRows, String expected) {
		assertThat(new Solution().convert(s, numRows)).isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
				arguments("A", 1, "A"),
				arguments("LEETCODEISHIRING", 3, "LCIRETOESIIGEDHN"),
				arguments("LEETCODEISHIRING", 4, "LDREOEIIECIHNTSG")
				);
	}

}
