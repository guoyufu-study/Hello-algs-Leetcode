package com.jasper.algs.leetcode.twopointers.qu0026;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testRemoveDuplicates(int[] nums, int[] expected) {
		int actual = new com.jasper.algs.leetcode.twopointers.qu0026.solu1.Solution().removeDuplicates(nums);
		
		assertThat(actual).isEqualTo(expected.length);
	}
	
	static Stream<Arguments> data() {

		return Stream.of(
				Arguments.arguments(new int[] {1,1,2}, new int[] {1,2}),
				Arguments.arguments(new int[] {0,0,1,3,12}, new int[] {0,1,3,12})
				);
	}

}
