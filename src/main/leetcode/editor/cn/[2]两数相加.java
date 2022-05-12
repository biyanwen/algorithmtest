//<p>给你两个 <strong>非空</strong> 的链表，表示两个非负的整数。它们每位数字都是按照 <strong>逆序</strong> 的方式存储的，并且每个节点只能存储 <strong>一位</strong> 数字。</p>
//
//<p>请你将两个数相加，并以相同形式返回一个表示和的链表。</p>
//
//<p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
//<pre>
//<strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
//<strong>输出：</strong>[7,0,8]
//<strong>解释：</strong>342 + 465 = 807.
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [0], l2 = [0]
//<strong>输出：</strong>[0]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//<strong>输出：</strong>[8,9,9,9,0,0,0,1]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li>每个链表中的节点数在范围 <code>[1, 100]</code> 内</li>
//	<li><code>0 <= Node.val <= 9</code></li>
//	<li>题目数据保证列表表示的数字不含前导零</li>
//</ul>
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li><li>数学</li></div></div><br><div><li>👍 8064</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tmp = head;

        boolean carry = false;

        while (true) {
            ListNode result = getResult(l1, l2, carry, tmp, head);
            if (result != null) {
                return result;
            }
            int addVal = carry ? l1.val + l2.val + 1 : l1.val + l2.val;
            carry = false;
            if (addVal >= 10) {
                addVal -= 10;
                carry = true;
            }
            tmp.next = new ListNode(addVal);
            tmp = tmp.next;

            l1 = l1.next;
            l2 = l2.next;
        }
    }

    private ListNode getResult(ListNode l1, ListNode l2, boolean carry, ListNode tmp, ListNode head) {

        if (l1 == null && l2 == null) {
            if (carry) {
                tmp.next = new ListNode(1);
            }
            return head.next;
        }
        if (l1 == null) {
            if (carry) {
                l2.val += 1;
                carry = l2.val >= 10;
                remainingCarry(l2, carry);
            }
            tmp.next = l2;
            return head.next;
        }
        if (l2 == null) {
            if (carry) {
                l1.val += 1;
                carry = l1.val >= 10;
                remainingCarry(l1, carry);
            }
            tmp.next = l1;
            return head.next;
        }
        return null;
    }

    private void remainingCarry(ListNode node, boolean carry) {
        ListNode tmp2 = node;
        while (carry) {
            tmp2.val -= 10;
            if (tmp2.next == null) {
                tmp2.next = new ListNode(1);
            } else {
                tmp2.next.val += 1;
            }
            tmp2 = tmp2.next;
            if (tmp2.val < 10) {
                carry = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
