//<p>在一个由 <code>'0'</code> 和 <code>'1'</code> 组成的二维矩阵内，找到只包含 <code>'1'</code> 的最大正方形，并返回其面积。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/max1grid.jpg" style="width: 400px; height: 319px;" />
//<pre>
//<strong>输入：</strong>matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//<strong>输出：</strong>4
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/26/max2grid.jpg" style="width: 165px; height: 165px;" />
//<pre>
//<strong>输入：</strong>matrix = [["0","1"],["1","0"]]
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>matrix = [["0"]]
//<strong>输出：</strong>0
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>m == matrix.length</code></li>
//	<li><code>n == matrix[i].length</code></li>
//	<li><code>1 <= m, n <= 300</code></li>
//	<li><code>matrix[i][j]</code> 为 <code>'0'</code> 或 <code>'1'</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li><li>矩阵</li></div></div><br><div><li>👍 1162</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] db = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        db[i][j] = 1;
                    } else {
                        db[i][j] = Math.min(Math.min(db[i - 1][j], db[i - 1][j - 1]), db[i][j - 1]) + 1;
                    }
                    res = Math.max(res, db[i][j]);
                }
            }
        }
        return res * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
