package com.jasper.algs.leetcode.qu0000;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NearestOneBitTests {

	@ParameterizedTest
	@CsvSource({
		"1,1",//0001
		"2,1",//0010
		"3,2",//0011
		"4,1",//0100
		"5,1",//0101
		"6,2",//0110
		"7,3",//0111
		"8,1",//1000
		"9,1",//1001
		"10,1",//1010
		"11,2",//1011
		"12,2",//1100
		"13,2",//1101
		"14,3",//1110
		"15,4",//1111
		"16,1",//1 0000
		"17,1",//1 0001
		"18,1",//1 0010
		"19,2",//1 0011
		"852, 2",//11 0101 0100
		"855, 3",//11 0101 0111
		"860, 3",//11 0101 1100
		"863, 5",//11 0101 1111
		"891, 4",//11 0111 1011
		"895, 7",//11 0111 1111
		"1022, 9",
		"1023, 10",
		"65535, 16"
	})
	void test(int num, int expected) {
		int actual = new NearestOneBit().lastOneBitLength(num);
		assertThat(actual).isEqualTo(expected);
	}
	
}
