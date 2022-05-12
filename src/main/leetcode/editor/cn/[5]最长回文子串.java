//<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "babad"
//<strong>输出：</strong>"bab"
//<strong>解释：</strong>"aba" 同样是符合题意的答案。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "cbbd"
//<strong>输出：</strong>"bb"
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
//	<li><code>s</code> 仅由数字和英文字母组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 5201</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        // 长度为 1 的字符串一定是回文串
        // 长度为 3 ，两边元素相同的一定是回文串
        // 长度大于3 两边元素相同的，如果去掉两边元素后还是回文串的话，那当前字符串也一定是回文串

        boolean[][] db = new boolean[length][length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            db[i][i] = true;
        }

        int beginIndex = 0;
        int totalLength = 1;
        for (int L = 2; L <= length; L++) {
            // i 为起始索引
            for (int i = 0; i < length; i++) {
                // 终止索引
                int j = L + i - 1;
                if (j >= length) {
                    break;
                }
                char aChar = chars[i];
                char bChar = chars[j];
                if (aChar == bChar) {
                    if ((j - i + 1) > 2) {
                        db[i][j] = db[i + 1][j - 1];
                        if (!db[i][j]) {
                            continue;
                        }
                    } else {
                        db[i][j] = true;
                    }
                } else {
                    db[i][j] = false;
                    continue;
                }

                if ((j - i + 1) > totalLength) {
                    beginIndex = i;
                    totalLength = j - i + 1;
                }
            }
        }
        return s.substring(beginIndex, totalLength + beginIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
