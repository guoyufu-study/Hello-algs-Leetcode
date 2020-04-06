package com.jasper.algs.leetcode.array.qu0004;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.jasper.algs.leetcode.array.qu0004.solu1.Solution;

class SolutionTest {

	@ParameterizedTest
	@MethodSource("data")
	void testFindMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
		double median = new Solution()
			.findMedianSortedArrays(nums1, nums2);
		assertThat(median).isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
				arguments(new int[] {}, new int[] {2,3}, 2.5),
				arguments(new int[] {2,3}, new int[] {}, 2.5),
				
				arguments(new int[] {2,3}, new int[] {1}, 2),
				arguments(new int[] {1,3}, new int[] {2}, 2),
				arguments(new int[] {1,2}, new int[] {3}, 2),
				
				arguments(new int[] {1,2}, new int[] {3,4}, 2.5),
				arguments(new int[] {3,4}, new int[] {1,2}, 2.5),
				
				arguments(new int[] {1,2,3}, new int[] {4,5,6}, 3.5),
				arguments(new int[] {5,6,7,8}, new int[] {1,2,3,4}, 4.5)
				
				);
	}

}
