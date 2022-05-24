//<p>你这个学期必须选修 <code>numCourses</code> 门课程，记为 <code>0</code> 到 <code>numCourses - 1</code> 。</p>
//
//<p>在选修某些课程之前需要一些先修课程。 先修课程按数组 <code>prerequisites</code> 给出，其中 <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> ，表示如果要学习课程 <code>a<sub>i</sub></code> 则 <strong>必须</strong> 先学习课程  <code>b<sub>i</sub></code><sub> </sub>。</p>
//
//<ul>
//	<li>例如，先修课程对 <code>[0, 1]</code> 表示：想要学习课程 <code>0</code> ，你需要先完成课程 <code>1</code> 。</li>
//</ul>
//
//<p>请你判断是否可能完成所有课程的学习？如果可以，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0]]
//<strong>输出：</strong>true
//<strong>解释：</strong>总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0],[0,1]]
//<strong>输出：</strong>false
//<strong>解释：</strong>总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= numCourses <= 10<sup>5</sup></code></li>
//	<li><code>0 <= prerequisites.length <= 5000</code></li>
//	<li><code>prerequisites[i].length == 2</code></li>
//	<li><code>0 <= a<sub>i</sub>, b<sub>i</sub> < numCourses</code></li>
//	<li><code>prerequisites[i]</code> 中的所有课程对 <strong>互不相同</strong></li>
//</ul>
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>图</li><li>拓扑排序</li></div></div><br><div><li>👍 1268</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean canFinish = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] figure = createFigure(numCourses, prerequisites);
        boolean[] visitable = new boolean[numCourses];
        boolean[] inUse = new boolean[numCourses];
        detection(figure, visitable, inUse);
        return canFinish;
    }

    private void detection(List<Integer>[] figure, boolean[] visitable, boolean[] inUse) {
        for (int i = 0; i < figure.length; i++) {
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
