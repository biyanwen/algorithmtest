//<p>现在你总共有 <code>numCourses</code> 门课需要选，记为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>numCourses - 1</code>。给你一个数组&nbsp;<code>prerequisites</code> ，其中 <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> ，表示在选修课程 <code>a<sub>i</sub></code> 前 <strong>必须</strong> 先选修&nbsp;<code>b<sub>i</sub></code> 。</p>
//
//<ul>
//	<li>例如，想要学习课程 <code>0</code> ，你需要先完成课程&nbsp;<code>1</code> ，我们用一个匹配来表示：<code>[0,1]</code> 。</li>
//</ul>
//
//<p>返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 <strong>任意一种</strong> 就可以了。如果不可能完成所有课程，返回 <strong>一个空数组</strong> 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0]]
//<strong>输出：</strong>[0,1]
//<strong>解释：</strong>总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 <code>[0,1] 。</code>
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//<strong>输出：</strong>[0,2,1,3]
//<strong>解释：</strong>总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是&nbsp;<code>[0,1,2,3]</code> 。另一个正确的排序是&nbsp;<code>[0,2,1,3]</code> 。</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>numCourses = 1, prerequisites = []
//<strong>输出：</strong>[0]
//</pre>
//
//<p>&nbsp;</p>
//<strong>提示：</strong>
//
//<ul>
//	<li><code>1 &lt;= numCourses &lt;= 2000</code></li>
//	<li><code>0 &lt;= prerequisites.length &lt;= numCourses * (numCourses - 1)</code></li>
//	<li><code>prerequisites[i].length == 2</code></li>
//	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li>
//	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
//	<li>所有<code>[a<sub>i</sub>, b<sub>i</sub>]</code> <strong>互不相同</strong></li>
//</ul>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>图</li><li>拓扑排序</li></div></div><br><div><li>👍 630</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean canFinish = true;
    private List<Integer> record = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        canFinish(numCourses, prerequisites);
        if (!canFinish) {
            return new int[0];
        }
        Collections.reverse(record);
        int[] result = new int[record.size()];
        for (int i = 0; i < record.size(); i++) {
            result[i] = record.get(i);
        }
        return result;
    }

    public void canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] figure = createFigure(numCourses, prerequisites);
        boolean[] visitable = new boolean[numCourses];
        boolean[] inUse = new boolean[numCourses];
        detection(figure, visitable, inUse);
    }

    private void detection(List<Integer>[] figure, boolean[] visitable, boolean[] inUse) {
        for (int i = 0; i < figure.length && canFinish; i++) {
            traverse(i, figure, visitable, inUse);
        }
    }

    private void traverse(int element, List<Integer>[] figure, boolean[] visitable, boolean[] inUse) {
        if (inUse[element]) {
            canFinish = false;
            return;
        }
        if (!visitable[element]) {
            inUse[element] = true;
            for (Integer integer : figure[element]) {
                traverse(integer, figure, visitable, inUse);
            }
            visitable[element] = true;
            inUse[element] = false;
            record.add(element);
        }
    }

    private List<Integer>[] createFigure(int numCourses, int[][] prerequisites) {
        List<Integer>[] figure = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            figure[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            figure[from].add(to);
        }
        return figure;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
