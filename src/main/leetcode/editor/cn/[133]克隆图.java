//<p>给你无向&nbsp;<strong><a href="https://baike.baidu.com/item/连通图/6460995?fr=aladdin" target="_blank">连通</a>&nbsp;</strong>图中一个节点的引用，请你返回该图的&nbsp;<a href="https://baike.baidu.com/item/深拷贝/22785317?fr=aladdin" target="_blank"><strong>深拷贝</strong></a>（克隆）。</p>
//
//<p>图中的每个节点都包含它的值 <code>val</code>（<code>int</code>） 和其邻居的列表（<code>list[Node]</code>）。</p>
//
//<pre>class Node {
//    public int val;
//    public List&lt;Node&gt; neighbors;
//}</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>测试用例格式：</strong></p>
//
//<p>简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（<code>val = 1</code>），第二个节点值为 2（<code>val = 2</code>），以此类推。该图在测试用例中使用邻接列表表示。</p>
//
//<p><strong>邻接列表</strong> 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。</p>
//
//<p>给定节点将始终是图中的第一个节点（值为 1）。你必须将&nbsp;<strong>给定节点的拷贝&nbsp;</strong>作为对克隆图的引用返回。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/133_clone_graph_question.png" style="height: 500px; width: 500px;"></p>
//
//<pre><strong>输入：</strong>adjList = [[2,4],[1,3],[2,4],[1,3]]
//<strong>输出：</strong>[[2,4],[1,3],[2,4],[1,3]]
//<strong>解释：
//</strong>图中有 4 个节点。
//节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
//节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
//节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
//节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/graph.png" style="height: 148px; width: 163px;"></p>
//
//<pre><strong>输入：</strong>adjList = [[]]
//<strong>输出：</strong>[[]]
//<strong>解释：</strong>输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>adjList = []
//<strong>输出：</strong>[]
//<strong>解释：</strong>这个图是空的，它不含任何节点。
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<p><img alt="" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/01/graph-1.png" style="height: 133px; width: 272px;"></p>
//
//<pre><strong>输入：</strong>adjList = [[2],[1]]
//<strong>输出：</strong>[[2],[1]]</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ol>
//	<li>节点数不超过 100 。</li>
//	<li>每个节点值&nbsp;<code>Node.val</code> 都是唯一的，<code>1 &lt;= Node.val &lt;= 100</code>。</li>
//	<li>无向图是一个<a href="https://baike.baidu.com/item/简单图/1680528?fr=aladdin" target="_blank">简单图</a>，这意味着图中没有重复的边，也没有自环。</li>
//	<li>由于图是无向的，如果节点 <em>p</em> 是节点 <em>q</em> 的邻居，那么节点 <em>q</em> 也必须是节点 <em>p</em>&nbsp;的邻居。</li>
//	<li>图是连通图，你可以从给定节点访问到所有节点。</li>
//</ol>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>图</li><li>哈希表</li></div></div><br><div><li>👍 502</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, cloneNode);
        if (node.neighbors != null && node.neighbors.size() > 0) {
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
        }
        return cloneNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
