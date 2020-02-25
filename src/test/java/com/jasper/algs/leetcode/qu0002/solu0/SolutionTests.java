package com.jasper.algs.leetcode.qu0002.solu0;

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
	public void testAddTwoNumbers0(ListNode l1, ListNode l2) {
		ListNode result = new com.jasper.algs.leetcode.qu0002.solu0.Solution().addTwoNumbers(l1, l2);
		
		print(l1, l2, result);
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
	 * 创建长度为n的链表，用它来表示一个十进制整数。
	 * 比如：1 -> 2 -> 3 表示十进制整数321；
	 */
	private static ListNode createListNodes(int n) {
		if(n<=0) return new ListNode(0);
		
		Random random = new Random();
		ListNode result = new ListNode(random.nextInt(10)), 
				next= result;
		for (int i = 1; i < n; i++) {
			next = next.next = new ListNode(random.nextInt(10));
		}
		
		return checkAndReplace(result);
	}

	/**
	 * 如果最高位是0，将其替换为非0值
	 */
	private static ListNode checkAndReplace(ListNode result) {
		ListNode last = result;
		while(last.next!=null) {
			last = last.next;
		}
		Random random = new Random();
		while(last.val == 0) {
			last.val = random.nextInt(10);
		}
		return result;
	}

	/**
	 * 打印
	 */
	private static void print(ListNode ll, ListNode l2, ListNode result) {
		print(ll);
		print(l2);
		print(result);
		System.out.println();
	}
	
	private static void print(ListNode ll) {
		do {
			System.out.printf("%d ",ll.val);
			ll = ll.next;
		} while (ll!=null);
		System.out.println();
	}
}
