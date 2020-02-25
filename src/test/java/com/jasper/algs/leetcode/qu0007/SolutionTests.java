package com.jasper.algs.leetcode.qu0007;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTests {
	
	@ParameterizedTest
	@MethodSource("data")
	public void testReverseInteger1(int x, int expected) {// 溢出检查+弹出推入
		int rev = new com.jasper.algs.leetcode.qu0007.solu1.Solution()
				.reverse(x);
		assertThat(rev).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	public void testReverseInteger2(int x, int expected) {// 优化溢出检查+弹出推入
		int rev = new com.jasper.algs.leetcode.qu0007.solu2.Solution()
				.reverse(x);
		assertThat(rev).isEqualTo(expected);
	}
	
	@ParameterizedTest
	@MethodSource("data")
	public void testReverseInteger3(int x, int expected) {//负数转正数=》优化溢出检查+弹出推入
		int rev = new com.jasper.algs.leetcode.qu0007.solu3.Solution()
				.reverse(x);
		assertThat(rev).isEqualTo(expected);
	}
	
	
	public static Stream<Arguments> data() {
		return Stream.of(
				arguments(1,1),//1位
				arguments(12,21),//2位
				arguments(12345678,87654321),//8位
				arguments(1_234_567_891,1_987_654_321),//10位不溢出
				
				arguments(1_111_111_122, 0),//10位溢出
				arguments(Integer.MAX_VALUE,0),//溢出 2_147_483_647
				arguments(Integer.MIN_VALUE,0),//溢出 -2_147_483_648
				
				arguments(-12,-21),//负数
				
				arguments(10,1),//尾数含0
				arguments(1_000,1),
				arguments(1_000_000_000,1)
				);
	}
}
