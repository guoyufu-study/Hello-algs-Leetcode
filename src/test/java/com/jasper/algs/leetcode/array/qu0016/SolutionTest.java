package com.jasper.algs.leetcode.array.qu0016;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testThreeSumClosest1(int[] nums, int target, int expected) {
		int actual = new com.jasper.algs.leetcode.array.qu0016.solu1.Solution().threeSumClosest(nums, target);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testThreeSumClosest2(int[] nums, int target, int expected) {
		int actual = new com.jasper.algs.leetcode.array.qu0016.solu2.Solution().threeSumClosest(nums, target);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testThreeSumClosest3(int[] nums, int target, int expected) {
		int actual = new com.jasper.algs.leetcode.array.qu0016.solu3.Solution().threeSumClosest(nums, target);
		assertThat(actual).isEqualTo(expected);
	}

	
	static Stream<Arguments> data() {
		return Stream.of(
//				arguments(new int[] {-1,2,1,-4}, 1, 2),
//				arguments(new int[] {-1,2,1,-4}, 1, 2),
				arguments(new int[] {-1,2,1,-4}, 1, 2)
				);
	}
}
