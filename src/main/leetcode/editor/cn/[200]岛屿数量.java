//<p>给你一个由 <code>'1'</code>（陆地）和 <code>'0'</code>（水）组成的的二维网格，请你计算网格中岛屿的数量。</p>
//
//<p>岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。</p>
//
//<p>此外，你可以假设该网格的四条边均被水包围。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//<strong>输出：</strong>1
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//<strong>输出：</strong>3
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>m == grid.length</code></li>
//	<li><code>n == grid[i].length</code></li>
//	<li><code>1 <= m, n <= 300</code></li>
//	<li><code>grid[i][j]</code> 的值为 <code>'0'</code> 或 <code>'1'</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>并查集</li><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 1735</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        // 因为所有元素长度都一样，不然要对每一个元素都获取一次长度。
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    removeIsland(grid, i, j);
                }
            }
        }
        return num;
    }

    private void removeIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        removeIsland(grid, i - 1, j);
        removeIsland(grid, i + 1, j);
        removeIsland(grid, i, j - 1);
        removeIsland(grid, i, j + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
