//<p>一个机器人位于一个 <code>m x n</code><em> </em>网格的左上角 （起始点在下图中标记为 “Start” ）。</p>
//
//<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。</p>
//
//<p>问总共有多少条不同的路径？</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img src="https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png" />
//<pre>
//<strong>输入：</strong>m = 3, n = 7
//<strong>输出：</strong>28</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>m = 3, n = 2
//<strong>输出：</strong>3
//<strong>解释：</strong>
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>m = 7, n = 3
//<strong>输出：</strong>28
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>m = 3, n = 3
//<strong>输出：</strong>6</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= m, n <= 100</code></li>
//	<li>题目数据保证答案小于等于 <code>2 * 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li><li>动态规划</li><li>组合数学</li></div></div><br><div><li>👍 1421</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 讲解文章 https://zhuanlan.zhihu.com/p/343474835
    public int uniquePaths(int m, int n) {
        int[][] db = new int[m][n];
        for (int i = 0; i < m; i++) {
            db[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            db[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                db[i][j] = db[i - 1][j] + db[i][j - 1];
            }
        }
        return db[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
