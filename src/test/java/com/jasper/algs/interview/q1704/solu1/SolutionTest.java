package com.jasper.algs.interview.q1704.solu1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testMissingNumber1(int[] nums, int expected) {//暴力求解：双层循环
		assertThat(new com.jasper.algs.interview.q1704.solu1.Solution().missingNumber(nums))
			.isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testMissingNumber2(int[] nums, int expected) {//求和相减
		assertThat(new com.jasper.algs.interview.q1704.solu2.Solution().missingNumber(nums))
		.isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testMissingNumber3(int[] nums, int expected) {//字典：先存再查
		assertThat(new com.jasper.algs.interview.q1704.solu3.Solution().missingNumber(nums))
		.isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	void testMissingNumber4(int[] nums, int expected) {//异或特性
		assertThat(new com.jasper.algs.interview.q1704.solu4.Solution().missingNumber(nums))
		.isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
				arguments(new int[] {3,0,1}, 2),
				arguments(new int[] {9,6,4,2,3,5,7,0,1}, 8)
						  
				);

	}
}
