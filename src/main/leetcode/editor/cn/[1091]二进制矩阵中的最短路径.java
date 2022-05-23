//<p>给你一个 <code>n x n</code> 的二进制矩阵 <code>grid</code> 中，返回矩阵中最短 <strong>畅通路径</strong> 的长度。如果不存在这样的路径，返回 <code>-1</code> 。</p>
//
//<p>二进制矩阵中的 畅通路径 是一条从 <strong>左上角</strong> 单元格（即，<code>(0, 0)</code>）到 右下角 单元格（即，<code>(n - 1, n - 1)</code>）的路径，该路径同时满足下述要求：</p>
//
//<ul>
//	<li>路径途经的所有单元格都的值都是 <code>0</code> 。</li>
//	<li>路径中所有相邻的单元格应当在 <strong>8 个方向之一</strong> 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。</li>
//</ul>
//
//<p><strong>畅通路径的长度</strong> 是该路径途经的单元格总数。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/example1_1.png" style="width: 500px; height: 234px;" />
//<pre>
//<strong>输入：</strong>grid = [[0,1],[1,0]]
//<strong>输出：</strong>2
//</pre>
//
//<p><strong>示例 2：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/example2_1.png" style="height: 216px; width: 500px;" />
//<pre>
//<strong>输入：</strong>grid = [[0,0,0],[1,1,0],[1,1,0]]
//<strong>输出：</strong>4
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>grid = [[1,0,0],[1,1,0],[1,1,0]]
//<strong>输出：</strong>-1
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>n == grid.length</code></li>
//	<li><code>n == grid[i].length</code></li>
//	<li><code>1 <= n <= 100</code></li>
//	<li><code>grid[i][j]</code> 为 <code>0</code> 或 <code>1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>广度优先搜索</li><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 196</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] != 0) {
			return -1;
		}
		if (grid.length == 1 && grid[0][0] == 0) {
			return 1;
		}
		int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
		int n = grid.length;
		int m = grid[0].length;

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		int num = 1;
		while (!queue.isEmpty()) {
			num++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] poll = queue.poll();
				for (int[] ints : dir) {
					int newN = poll[0] + ints[0];
					int newM = poll[1] + ints[1];
					if (newN >= 0 && newN < n && newM >= 0 && newM < m && !visited[newN][newM] && grid[newN][newM] == 0) {
						if (newN == n - 1 && newM == m - 1) {
							return num;
						}
						visited[newN][newM] = true;
						queue.offer(new int[]{newN, newM});
					}
				}
			}
		}
		return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
