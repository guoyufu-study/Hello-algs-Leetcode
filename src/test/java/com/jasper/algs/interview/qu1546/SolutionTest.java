package com.jasper.algs.interview.qu1546;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {
	
	@ParameterizedTest
	@MethodSource("data")
	void testMaxAliveYear1(int[] birth, int[] death, int expected) {//暴力求解
		assertThat(new com.jasper.algs.interview.qu1546.solu1.Solution().maxAliveYear(birth, death))
		.isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("data")
	void testMaxAliveYear2(int[] birth, int[] death, int expected) {//暴力求解
		assertThat(new com.jasper.algs.interview.qu1546.solu2.Solution().maxAliveYear(birth, death))
			.isEqualTo(expected);
	}

	@ParameterizedTest
	@MethodSource("data")
	void testMaxAliveYear3(int[] birth, int[] death, int expected) {
		assertThat(new com.jasper.algs.interview.qu1546.solu3.Solution().maxAliveYear(birth, death))
		.isEqualTo(expected);
	}
	
	static Stream<Arguments> data() {
		return Stream.of(
				arguments(new int[] {1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901},
						  new int[] {1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969},
						  1960)
				);

	}
}
