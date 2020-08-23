package com.jasper.algs.leetcode.bitmanipulation.qu0137;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber1(int[] nums, int expected) {//HashSet 求和
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0137.solu1.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber2(int[] nums, int expected) {//HashMap 计数
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0137.solu2.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber4(int[] nums, int expected) {//位运算：统计每个位上出现1的次数取模
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0137.solu4.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber5(int[] nums, int expected) {//位运算：卡诺图法生成状态转移公式
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0137.solu5.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber6(int[] nums, int expected) {//位运算：位掩码
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0137.solu6.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	
	static Stream<Arguments> data() {
		return Stream.of(
				arguments(new int[] {1}, 1),
				arguments(new int[] {2,2,3,2}, 3),
				arguments(new int[] {0,1,0,1,0,1,99}, 99)
				);
	}

}
