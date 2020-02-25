package com.jasper.algs.leetcode.qu0001;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTests {

	@ParameterizedTest
	@MethodSource("twoSumProvider")
	public void testTwoSum1(int[] nums, int target, int[] expecteds) {
		int[] actuals = new com.jasper.algs.leetcode.qu0001.solu1.Solution().twoSum(nums, target);
		assertArrayEquals(expecteds, actuals);
	}
	
	@ParameterizedTest
	@MethodSource("twoSumProvider")
	public void testTwoSum2(int[] nums, int target, int[] expecteds) {
		int[] actuals = new com.jasper.algs.leetcode.qu0001.solu3.Solution().twoSum(nums, target);
		assertArrayEquals(expecteds, actuals);
	}
	
	@ParameterizedTest
	@MethodSource("twoSumProvider")
	public void testTwoSum3(int[] nums, int target, int[] expecteds) {
		int[] actuals = new com.jasper.algs.leetcode.qu0001.solu4.Solution().twoSum(nums, target);
		assertArrayEquals(expecteds, actuals);
	}
	
	

	static Stream<Arguments> twoSumProvider() {
	    return Stream.of(
	        arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0,1}),
	        arguments(new int[]{2, 7, 11, 15}, 18, new int[]{1,2})
	    );
	}
}
