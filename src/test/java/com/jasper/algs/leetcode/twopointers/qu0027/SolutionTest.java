package com.jasper.algs.leetcode.twopointers.qu0027;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testRemoveElement1(int[] nums, int val, int expected) {//拷贝覆盖
		int actual = new com.jasper.algs.leetcode.twopointers.qu0027.solu1.Solution().removeElement(nums, val);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testRemoveElement2(int[] nums, int val, int expected) {//交换移除
		int actual = new com.jasper.algs.leetcode.twopointers.qu0027.solu2.Solution().removeElement(nums, val);
		assertThat(actual).isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
				Arguments.arguments(new int[] {1}, 1, 0),
				Arguments.arguments(new int[] {3,2,2,3}, 3, 2),
				Arguments.arguments(new int[] {0,1,2,2,3,0,4,2}, 2, 5)
				);
	}

}
