//<p>给定一个包含非负整数的 <code><em>m</em> x <em>n</em></code> 网格 <code>grid</code> ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。</p>
//
//<p><strong>说明：</strong>每次只能向下或者向右移动一步。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>输入：</strong>grid = [[1,3,1],[1,5,1],[4,2,1]]
//<strong>输出：</strong>7
//<strong>解释：</strong>因为路径 1→3→1→1→1 的总和最小。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>grid = [[1,2,3],[4,5,6]]
//<strong>输出：</strong>12
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>m == grid.length</code></li>
//	<li><code>n == grid[i].length</code></li>
//	<li><code>1 <= m, n <= 200</code></li>
//	<li><code>0 <= grid[i][j] <= 100</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 1259</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // db[i][j] = Math.min( db[i-1][j] , db[i][j-1] ) + grid[i][j];
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] db = new int[m][n];
        db[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            db[i][0] = db[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            db[0][i] = db[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                db[i][j] = Math.min(db[i - 1][j], db[i][j - 1]) + grid[i][j];
            }
        }
        return db[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
