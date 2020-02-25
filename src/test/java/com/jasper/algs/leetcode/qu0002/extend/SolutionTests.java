package com.jasper.algs.leetcode.qu0002.extend;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.jasper.algs.leetcode.qu0002.ListNode;

public class SolutionTests {

	@ParameterizedTest
	@MethodSource("createListNodes")
	public void testAddTwoNumbersExtend(ListNode l1, ListNode l2) {
		ListNode result = new com.jasper.algs.leetcode.qu0002.extend.Solution().addTwoNumbers(l1, l2);
		
		print(l1,l2,result);
	}

	static Stream<Arguments> createListNodes() {
		return Stream.of(
				arguments(createListNodes(2), createListNodes(5)),
				arguments(createListNodes(8), createListNodes(8)),
				arguments(createListNodes(15), createListNodes(12)), 
				arguments(createListNodes(65), createListNodes(72))
		);
	}

	/**
	 * 创建长度为n的链表，用它来表示一个十进制整数。 比如：1 -> 2 -> 3 表示十进制整数321；
	 */
	private static ListNode createListNodes(int n) {
		if (n <= 0)
			return new ListNode(0);

		Random random = new Random();
		ListNode result = new ListNode(random.nextInt(10)), next = result;
		for (int i = 1; i < n; i++) {
			next = next.next = new ListNode(random.nextInt(10));
		}

		return checkAndReplace(result);
	}

	/**
	 * 如果最高位是0，将其替换为非0值
	 */
	private static ListNode checkAndReplace(ListNode result) {
		Random random = new Random();
		while (result.val == 0) {
			result.val = random.nextInt(10);
		}
		return result;
	}

	/**
	 * 打印
	 */
	private static void print(ListNode l1, ListNode l2, ListNode result) {
		int count = count(result);
		System.out.printf("  %s%n", print(l1, count));
		System.out.printf("+ %s%n", print(l2, count));
		System.out.printf("= %s%n", print(result, count));
		System.out.println();
	}
	
	private static int count(ListNode result) {
		int count = 0;
		while (result != null) {
			result = result.next;
			count++;
		}
		return count;
	}
	
	private static StringBuilder print(ListNode ln, int count) {
		StringBuilder sb = new StringBuilder();
		do {
			count--;
			sb.append(ln.val).append(" ");
			ln = ln.next;
		} while (ln != null);

		while (count-- != 0) {
			sb.insert(0, "0 ");
		}
		
		return sb;
	}
}
