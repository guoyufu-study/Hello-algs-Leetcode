package com.jasper.algs.leetcode.twopointers.qu0283;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testMoveZeroes1(int[] nums, int[] expected) {
		new com.jasper.algs.leetcode.twopointers.qu0283.solu1.Solution().moveZeroes(nums);
		
		assertThat(nums).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testMoveZeroes2(int[] nums, int[] expected) {
		new com.jasper.algs.leetcode.twopointers.qu0283.solu2.Solution().moveZeroes(nums);
		
		assertThat(nums).isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {

		return Stream.of(
				Arguments.arguments(new int[] {1}, new int[] {1}),
				Arguments.arguments(new int[] {0,1,0,3,12}, new int[] {1,3,12,0,0})
				);
	}

}
