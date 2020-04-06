package com.jasper.algs.leetcode.bitmanipulation.qu0136;

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
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0136.solu1.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber2(int[] nums, int expected) {//HashMap 计数
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0136.solu2.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber3(int[] nums, int expected) {//位运算:遍历32位计数取模
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0136.solu3.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber4(int[] nums, int expected) {//位运算:位掩码-异或
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0136.solu4.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber5(int[] nums, int expected) {//位运算:卡诺图生成状态转移公式
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0136.solu5.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testSingleNumber6(int[] nums, int expected) {// 双层循环
		int actual = new com.jasper.algs.leetcode.bitmanipulation.qu0136.solu6.Solution()
				.singleNumber(nums);
		assertThat(actual).isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
				arguments(new int[] {1}, 1),
				arguments(new int[] {2,2,1}, 1),
				arguments(new int[] {4,1,2,1,2}, 4)
				);
	}

}
