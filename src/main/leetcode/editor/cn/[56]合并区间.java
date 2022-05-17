//<p>以数组 <code>intervals</code> 表示若干个区间的集合，其中单个区间为 <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> 。请你合并所有重叠的区间，并返回&nbsp;<em>一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间</em>&nbsp;。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>intervals = [[1,3],[2,6],[8,10],[15,18]]
//<strong>输出：</strong>[[1,6],[8,10],[15,18]]
//<strong>解释：</strong>区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>intervals = [[1,4],[4,5]]
//<strong>输出：</strong>[[1,5]]
//<strong>解释：</strong>区间 [1,4] 和 [4,5] 可被视为重叠区间。</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
//	<li><code>intervals[i].length == 2</code></li>
//	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>排序</li></div></div><br><div><li>👍 1480</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
// 题解链接 https://www.toobug.cn/post/4648.html
class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing(t -> t[0]));
		List<int[]> res = new ArrayList<>();

		for (int[] interval : intervals) {
			if (res.isEmpty()) {
				res.add(interval);
				continue;
			}
			int[] ints = res.get(res.size() - 1);
			int rightBorder = ints[1];
			// 前一个区间的右边界大于等于后一个区间的左边界说明有重合
			if (rightBorder >= interval[0]) {
				// 前一个区间的右边界小于后一个区间的右边界则更新前一个区间的右边界
				if (rightBorder < interval[1]) {
					ints[1] = interval[1];
				}
			} else {
				// 如果不符合 if 条件说明不重合，直接添加到集合中
				res.add(interval);
			}
		}
		return res.toArray(new int[res.size()][]);
	}
}
//leetcode submit region end(Prohibit modification and deletion)
