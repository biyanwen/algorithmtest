//<p>给定两个字符串 <code>text1</code> 和 <code>text2</code>，返回这两个字符串的最长 <strong>公共子序列</strong> 的长度。如果不存在 <strong>公共子序列</strong> ，返回 <code>0</code> 。</p>
//
//<p>一个字符串的 <strong>子序列</strong><em> </em>是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。</p>
//
//<ul>
//	<li>例如，<code>"ace"</code> 是 <code>"abcde"</code> 的子序列，但 <code>"aec"</code> 不是 <code>"abcde"</code> 的子序列。</li>
//</ul>
//
//<p>两个字符串的 <strong>公共子序列</strong> 是这两个字符串所共同拥有的子序列。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>text1 = "abcde", text2 = "ace" 
//<strong>输出：</strong>3  
//<strong>解释：</strong>最长公共子序列是 "ace" ，它的长度为 3 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>text1 = "abc", text2 = "abc"
//<strong>输出：</strong>3
//<strong>解释：</strong>最长公共子序列是 "abc" ，它的长度为 3 。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>text1 = "abc", text2 = "def"
//<strong>输出：</strong>0
//<strong>解释：</strong>两个字符串没有公共子序列，返回 0 。
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= text1.length, text2.length <= 1000</code></li>
//	<li><code>text1</code> 和 <code>text2</code> 仅由小写英文字符组成。</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 1005</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] charsOne;
    char[] charsTwo;
    int[][] visited;

    public int longestCommonSubsequence(String text1, String text2) {
        charsOne = text1.toCharArray();
        charsTwo = text2.toCharArray();
        visited = new int[charsOne.length][charsTwo.length];
        for (int[] ints : visited) {
            Arrays.fill(ints, -1);
        }
        return db(charsOne, 0, charsTwo, 0);
    }

    private int db(char[] charsOne, int i, char[] charsTwo, int j) {
        if (i == charsOne.length || j == charsTwo.length) {
            return 0;
        }
        if (visited[i][j] != -1) {
            return visited[i][j];
        }
        if (charsOne[i] == charsTwo[j]) {
            visited[i][j] = 1 + db(charsOne, i + 1, charsTwo, j + 1);
        } else {
            visited[i][j] = Math.max(db(charsOne, i, charsTwo, j + 1), db(charsOne, i + 1, charsTwo, j));
        }
        return visited[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
