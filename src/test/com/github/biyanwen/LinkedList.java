package com.github.biyanwen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author byw
 * @Date 2022/2/23 21:46
 */
public class LinkedList {

	/**
	 * 题目：反转链表
	 * <p>
	 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
	 * <p>
	 * 数据范围： 0\leq n\leq10000≤n≤1000
	 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
	 * <p>
	 * 如当输入链表{1,2,3}时，
	 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
	 */
	@Test
	public void reverseLinkedListTest() {
		Node node = createNode(5);
		Node reverseLinkedList = reverseLinkedList(node);
		Assertions.assertEquals(5,reverseLinkedList.value);
		Assertions.assertEquals(4,reverseLinkedList.next.value);
	}

	private Node reverseLinkedList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node lastNode = reverseLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		return lastNode;
	}

	private Node createNode(int size) {
		Node head = null;
		Node tmpNode = null;
		for (int i = 1; i <= size; i++) {
			if (head == null) {
				head = new Node();
				head.setValue(i);
				tmpNode = head;
			} else {
				Node node = new Node();
				node.setValue(i);
				tmpNode.setNext(node);
				tmpNode = node;
			}
		}
		return head;
	}

	public static class Node {
		private int value;
		private Node next;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public LinkedList.Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
