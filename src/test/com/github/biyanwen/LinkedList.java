package com.github.biyanwen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

	/**
	 * 合并两个有序链表
	 * 输入： 链表1 1 -> 3 -> 5 ; 链表2 2-> 4 -> 6
	 * 输出： 1-> 2 -> 3 -> 4 -> 5 -> 6
	 */
	@Test
	public void mergeTwoSoredLinkedListTest() {
		Node oneSoredLined = createOneSoredLinedList();
		Node twoSoredLined = createTwoSoredLinedList();

		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node newHead = nodeAlgorithm.mergeTwoLinkedList(oneSoredLined, twoSoredLined);
		Assertions.assertEquals(1, newHead.value);
		Assertions.assertEquals(2, newHead.next.value);
		Assertions.assertEquals(3, newHead.next.next.value);
		Assertions.assertEquals(4, newHead.next.next.next.value);
		Assertions.assertEquals(5, newHead.next.next.next.next.value);

	}

	/**
	 * 合并 K 个有序链表
	 */
	@Test
	public void mergeKOfLinkedListTest() {
		NodeAlgorithm nodeAlgorithm = new NodeAlgorithm();
		Node nodeOne = nodeAlgorithm.createNode(3);
		Node nodeTwo = nodeAlgorithm.createNode(3);
		Node nodeThree = nodeAlgorithm.createNode(3);
		List<Node> nodes = Arrays.asList(nodeOne, nodeTwo, nodeThree);
		Node mergeKOfLinkedList = nodeAlgorithm.mergeKOfLinkedList(nodes);

		Assertions.assertEquals(1, mergeKOfLinkedList.value);
		Assertions.assertEquals(1, mergeKOfLinkedList.next.value);
		Assertions.assertEquals(1, mergeKOfLinkedList.next.next.value);
		Assertions.assertEquals(2, mergeKOfLinkedList.next.next.next.value);
		Assertions.assertEquals(2, mergeKOfLinkedList.next.next.next.next.value);
		Assertions.assertEquals(2, mergeKOfLinkedList.next.next.next.next.next.value);
		Assertions.assertEquals(3, mergeKOfLinkedList.next.next.next.next.next.next.value);
		Assertions.assertEquals(3, mergeKOfLinkedList.next.next.next.next.next.next.next.value);
		Assertions.assertEquals(3, mergeKOfLinkedList.next.next.next.next.next.next.next.next.value);
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

	public static class Node implements Comparable<Node> {
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

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
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
		 * 合并两个有序链表
		 *
		 * @param oneSoredLined 链表1
		 * @param twoSoredLined 链表2
		 * @return {@link Node}
		 */
		public Node mergeTwoLinkedList(Node oneSoredLined, Node twoSoredLined) {
			if (oneSoredLined == null) {
				return twoSoredLined;
			}
			if (twoSoredLined == null) {
				return oneSoredLined;
			}
			Node newHead;
			if (oneSoredLined.value <= twoSoredLined.value) {
				newHead = oneSoredLined;
				oneSoredLined.next = mergeTwoLinkedList(oneSoredLined.next, twoSoredLined);
			} else {
				newHead = twoSoredLined;
				twoSoredLined.next = mergeTwoLinkedList(oneSoredLined, twoSoredLined.next);
			}
			return newHead;
		}

		/**
		 * 合并 K 个链表
		 *
		 * @param nodes 节点
		 * @return {@link Node}
		 */
		public Node mergeKOfLinkedList(List<Node> nodes) {
			Sort.SortAlgorithm sortAlgorithm = new Sort.SortAlgorithm();
			Sort.HeapSortBean<Node> heapSortBean = sortAlgorithm.createHeapSortBean();
			for (Node node : nodes) {
				while (node != null) {
					heapSortBean.add(node);
					node = node.next;
				}
			}
			Node newHead = null;
			Node tmpNode = null;
			while (!heapSortBean.isEmpty()) {
				Node poll = heapSortBean.poll();
				if (newHead == null) {
					newHead = poll;
					tmpNode = poll;
				} else {
					tmpNode.next = poll;
					tmpNode = tmpNode.next;
				}
			}
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

	}
}
