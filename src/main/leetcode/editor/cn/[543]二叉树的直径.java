//<p>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 :</strong><br>
//给定二叉树</p>
//
//<pre>          1
//         / \
//        2   3
//       / \     
//      4   5    
//</pre>
//
//<p>返回&nbsp;<strong>3</strong>, 它的长度是路径 [4,2,1,3] 或者&nbsp;[5,2,1,3]。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>注意：</strong>两结点之间的路径长度是以它们之间边的数目表示。</p>
//<div><div>Related Topics</div><div><li>树</li><li>深度优先搜索</li><li>二叉树</li></div></div><br><div><li>👍 1045</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxValue = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depthOf(root);
        return maxValue - 1;
    }

    private int depthOf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = depthOf(root.left);
        int R = depthOf(root.right);

        int length = L + R + 1;
        maxValue = Math.max(maxValue, length);
        // 这里是要点，返回一棵树的最大子树的长度。因为对于其他节点来说，当前树可能
        // 只是另一个棵树的一个子树，所以需要知道一个子树的最大长度，按照这样的逻辑同时获取到左子树和右子树
        // 的最大长度后，将其相加就求出当前树的最大深度了。
        return Math.max(L, R) + 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
