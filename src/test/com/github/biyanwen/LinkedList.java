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
		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node node = nodeAlgorithm.createNode(5);
		Node reverseLinkedList = nodeAlgorithm.reverseLinkedList(node);
		Assertions.assertEquals(5, reverseLinkedList.value);
		Assertions.assertEquals(4, reverseLinkedList.next.value);
	}

	/**
	 * 题目：反转链表前 n 个节点
	 * 输入链表： 1 -> 2 -> 3 -> 4 -> 5
	 * 返回链表： 3 -> 2 -> 1 -> 4 -> 5
	 */
	@Test
	public void reverseLinkedListBeforeNTest() {
		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node node = nodeAlgorithm.createNode(5);
		Node beforeN = nodeAlgorithm.reverseLinkedListBeforeN(node, 3);

		Assertions.assertEquals(3, beforeN.value);
		Assertions.assertEquals(2, beforeN.next.value);
		Assertions.assertEquals(1, beforeN.next.next.value);
		Assertions.assertEquals(4, beforeN.next.next.next.value);
		Assertions.assertEquals(5, beforeN.next.next.next.next.value);

	}

	/**
	 * 题目：反向链接指定区间内的节点 n = 3, m= 5
	 * 输入链表： 1 -> 2 -> 3 -> 4 -> 5
	 * 返回链表： 1 -> 2 -> 5 -> 4 -> 3
	 */
	@Test
	public void reverseLinkedListIntervalTest() {
		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node node = nodeAlgorithm.createNode(5);
		Node interval = nodeAlgorithm.reverseLinkedListInterval(node, 3, 5);

		Assertions.assertEquals(1, interval.value);
		Assertions.assertEquals(2, interval.next.value);
		Assertions.assertEquals(5, interval.next.next.value);
		Assertions.assertEquals(4, interval.next.next.next.value);
		Assertions.assertEquals(3, interval.next.next.next.next.value);
	}

	/**
	 * 链表中的节点每k个一组翻转
	 * <p>
	 * 输入链表： 1 -> 2 -> 3 -> 4 -> 5
	 * 返回链表： 2 -> 1 -> 4 -> 3 -> 5
	 */
	@Test
	public void reverseLinkedListGroupOfKTest() {
		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node node = nodeAlgorithm.createNode(5);
		Node groupOfK = nodeAlgorithm.reverseLinkedListGroupOfK(node, 2);
		Assertions.assertEquals(2, groupOfK.value);
		Assertions.assertEquals(1, groupOfK.next.value);
		Assertions.assertEquals(4, groupOfK.next.next.value);
		Assertions.assertEquals(3, groupOfK.next.next.next.value);
		Assertions.assertEquals(5, groupOfK.next.next.next.next.value);
	}

	@Test
	public void mergeTwoSoredLinkedListTest() {
		Node oneSoredLined = createOneSoredLinedList();
		Node twoSoredLined = createTwoSoredLinedList();

		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node newHead = nodeAlgorithm.mergeTwoLists(oneSoredLined, twoSoredLined);
		Assertions.assertEquals(1, newHead.value);
		Assertions.assertEquals(2, newHead.next.value);
		Assertions.assertEquals(3, newHead.next.next.value);
		Assertions.assertEquals(4, newHead.next.next.next.value);
		Assertions.assertEquals(5, newHead.next.next.next.next.value);

	}

	public Node mergeTwoLists(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.value < l2.value) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

	}

	@Test
	public void tt() {

		Node oneSoredLined = createOneSoredLinedList();
		for (Node cur = oneSoredLined; cur != null; cur = cur.next) {
			System.out.println(cur.value);
		}
	}


	private Node createTwoSoredLinedList() {
		Node three = new Node();
		three.setValue(6);

		Node two = new Node();
		two.setValue(4);
		two.setNext(three);

		Node head = new Node();
		head.setValue(2);
		head.setNext(two);

		return head;
	}

	private Node createOneSoredLinedList() {
		Node three = new Node();
		three.setValue(5);

		Node two = new Node();
		two.setValue(3);
		two.setNext(three);

		Node head = new Node();
		head.setValue(1);
		head.setNext(two);

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

	/**
	 * 节点算法
	 *
	 * @author byw
	 * @date 2022/02/26
	 */
	private static class NodeAlgorithm {

		/**
		 * 下一个节点
		 */
		private Node nextOneNode;
		/**
		 * 前一个节点
		 */
		private Node beforeOneNode;

		/**
		 * 头缓存
		 */
		private Node headCache;

		/**
		 * 反向链接列表
		 *
		 * @param head 头
		 * @return {@link Node}
		 */
		private Node reverseLinkedList(Node head) {
			if (head == null || head.next == null) {
				return head;
			}
			Node lastNode = reverseLinkedList(head.next);
			head.next.next = head;
			head.next = null;
			return lastNode;
		}


		/**
		 * 反向链接列表前 N 个节点
		 *
		 * @param head 头
		 * @param n    n
		 * @return {@link Node}
		 */

		private Node reverseLinkedListBeforeN(Node head, int n) {
			if (head == null) {
				return null;
			}
			if (n == 1) {
				nextOneNode = head.next;
				return head;
			}
			Node lastNode = reverseLinkedListBeforeN(head.next, n - 1);
			head.next.next = head;
			head.next = nextOneNode;
			return lastNode;
		}

		/**
		 * 反转链表指定区间的节点
		 *
		 * @param head       头
		 * @param startIndex 开始索引
		 * @param endIndex   结束索引
		 * @return {@link Node}
		 */
		public Node reverseLinkedListInterval(Node head, int startIndex, int endIndex) {
			if (startIndex == 1) {
				return reverseLinkedListBeforeN(head, endIndex);
			}
			head.next = reverseLinkedListInterval(head.next, startIndex - 1, endIndex - 1);
			return head;
		}

		/**
		 * K 个一组反转链表
		 *
		 * @param head 头
		 * @param k    k
		 * @return {@link Node}
		 */
		public Node reverseLinkedListGroupOfK(Node head, int k) {
			if (head == null || head.next == null) {
				return head;
			}
			Node tmpNode = head;
			// 判断链表是否够长 k
			for (int i = 0; i < k; i++) {
				tmpNode = tmpNode.next;
				if (tmpNode == null) {
					return head;
				}
			}
			// 如果够长就反转以 head 为头结点的前 k 个节点
			Node newHead = reverseLinkedListBeforeN(head, k);
			head.next = reverseLinkedListGroupOfK(head.next, k);
			return newHead;
		}

		/**
		 * 创建节点
		 *
		 * @param size 大小
		 * @return {@link Node}
		 */
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

		public Node mergeTwoLists(Node oneSoredLined, Node twoSoredLined) {
			if (oneSoredLined == null) {
				return twoSoredLined;
			}
			if (twoSoredLined == null) {
				return oneSoredLined;
			}
			Node newHead;
			if (oneSoredLined.value <= twoSoredLined.value) {
				newHead = oneSoredLined;
				oneSoredLined.next = mergeTwoLists(oneSoredLined.next, twoSoredLined);
			} else {
				newHead = twoSoredLined;
				twoSoredLined.next = mergeTwoLists(oneSoredLined, twoSoredLined.next);
			}
			return newHead;
		}
	}
}
