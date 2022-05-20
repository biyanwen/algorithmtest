//给你单链表的头指针 <code>head</code> 和两个整数 <code>left</code> 和 <code>right</code> ，其中 <code>left <= right</code> 。请你反转从位置 <code>left</code> 到位置 <code>right</code> 的链表节点，返回 <strong>反转后的链表</strong> 。
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev2ex2.jpg" style="width: 542px; height: 222px;" />
//<pre>
//<strong>输入：</strong>head = [1,2,3,4,5], left = 2, right = 4
//<strong>输出：</strong>[1,4,3,2,5]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = [5], left = 1, right = 1
//<strong>输出：</strong>[5]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>链表中节点数目为 <code>n</code></li>
//	<li><code>1 <= n <= 500</code></li>
//	<li><code>-500 <= Node.val <= 500</code></li>
//	<li><code>1 <= left <= right <= n</code></li>
//</ul>
//
//<p> </p>
//
//<p><strong>进阶：</strong> 你可以使用一趟扫描完成反转吗？</p>
//<div><div>Related Topics</div><div><li>链表</li></div></div><br><div><li>👍 1283</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	// todo 还没通透
	public ListNode reverseBetween(ListNode listNode, int m, int n) {
		if (listNode == null) {
			return null;
		}
		if (m == 1) {
			return reverseBeforeN(listNode, n);
		}
		ListNode middleNode = reverseBetween(listNode.next, m - 1, n - 1);
		listNode.next = middleNode;
		return listNode;
	}

	private ListNode nextNode;

	private ListNode reverseBeforeN(ListNode listNode, int n) {
		if (listNode == null) {
			return null;
		}
		if (n == 1) {
			nextNode = listNode.next;
			return listNode;
		}
		ListNode newHead = reverseBeforeN(listNode.next, n - 1);
		listNode.next.next = listNode;
		listNode.next = nextNode;
		return newHead;
	}

}
//leetcode submit region end(Prohibit modification and deletion)
