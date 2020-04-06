package com.jasper.algs.leetcode.maths.qu0233;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testCountDigitOne1(int n, int expected) {//遍历求解：双层循环
		int actual = new com.jasper.algs.leetcode.maths.qu0233.solu1.Solution()
				.countDigitOne(n);
		assertThat(actual).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testCountDigitOne2(int n, int expected) {//
		int actual = new com.jasper.algs.leetcode.maths.qu0233.solu2.Solution()
				.countDigitOne(n);
		assertThat(actual).isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
//				arguments(0, 0),
//				arguments(2, 1),
//				arguments(12, 5),
//				arguments(13, 6),
//				arguments(99, 20),
//				arguments(109, 31),
//				arguments(2, 1),
//				arguments(22, 13),
//				arguments(222, 153),
//				arguments(2222, 1753),
//				arguments(9, 1),
//				arguments(99, 20),
//				arguments(999, 300),
//				arguments(9999, 4000),
//				arguments(-1, 0),
				arguments(1410065408, 1737167499)
						  
				);

	}
}
