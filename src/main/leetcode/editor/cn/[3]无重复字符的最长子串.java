//<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例&nbsp;1:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "abcabcbb"
//<strong>输出: </strong>3 
//<strong>解释:</strong> 因为无重复字符的最长子串是 <code>"abc"，所以其</code>长度为 3。
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "bbbbb"
//<strong>输出: </strong>1
//<strong>解释: </strong>因为无重复字符的最长子串是 <code>"b"</code>，所以其长度为 1。
//</pre>
//
//<p><strong>示例 3:</strong></p>
//
//<pre>
//<strong>输入: </strong>s = "pwwkew"
//<strong>输出: </strong>3
//<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>"wke"</code>，所以其长度为 3。
//&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>"pwke"</code>&nbsp;是一个<em>子序列，</em>不是子串。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
//	<li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li>
//</ul>
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>滑动窗口</li></div></div><br><div><li>👍 7541</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> cacheSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int result = 0;
        int firstPointerTo = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                cacheSet.remove(chars[i -1]);
            }
            while (firstPointerTo < chars.length && !cacheSet.contains(chars[firstPointerTo])) {
                cacheSet.add(chars[firstPointerTo]);
                firstPointerTo++;
            }
            result = Math.max(result, cacheSet.size());
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
