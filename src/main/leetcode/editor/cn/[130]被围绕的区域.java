//给你一个 <code>m x n</code> 的矩阵 <code>board</code> ，由若干字符 <code>'X'</code> 和 <code>'O'</code> ，找到所有被 <code>'X'</code> 围绕的区域，并将这些区域里所有的 <code>'O'</code> 用 <code>'X'</code> 填充。
//<div class="original__bRMd">
//<div>
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/xogrid.jpg" style="width: 550px; height: 237px;" />
//<pre>
//<strong>输入：</strong>board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//<strong>输出：</strong>[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//<strong>解释：</strong>被围绕的区间不会存在于边界上，换句话说，任何边界上的 <code>'O'</code> 都不会被填充为 <code>'X'</code>。 任何不在边界上，或不与边界上的 <code>'O'</code> 相连的 <code>'O'</code> 最终都会被填充为 <code>'X'</code>。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>board = [["X"]]
//<strong>输出：</strong>[["X"]]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>m == board.length</code></li>
//	<li><code>n == board[i].length</code></li>
//	<li><code>1 <= m, n <= 200</code></li>
//	<li><code>board[i][j]</code> 为 <code>'X'</code> 或 <code>'O'</code></li>
//</ul>
//</div>
//</div>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>并查集</li><li>数组</li><li>矩阵</li></div></div><br><div><li>👍 800</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public void solve(char[][] board) {
		int n = board.length;
		int m = board[0].length;
		List<Reduction> reductionList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			fill(board, 0, i, reductionList);
			fill(board, n - 1, i, reductionList);
		}
		for (int i = 0; i < n; i++) {
			fill(board, i, 0, reductionList);
			fill(board, i, m - 1, reductionList);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				fill(board, i, j, new ArrayList<>());
			}
		}
		for (Reduction reduction : reductionList) {
			board[reduction.i][reduction.j] = 'O';
		}
	}

	private void fill(char[][] board, int i, int j, List<Reduction> reductionList) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return;
		}
		if (board[i][j] == 'X') {
			return;
		}
		board[i][j] = 'X';
		reductionList.add(new Reduction(i, j));
		fill(board, i - 1, j, reductionList);
		fill(board, i + 1, j, reductionList);
		fill(board, i, j - 1, reductionList);
		fill(board, i, j + 1, reductionList);
	}

	private static class Reduction {
		private int i;
		private int j;

		public Reduction(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)
