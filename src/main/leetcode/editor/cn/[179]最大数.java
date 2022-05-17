//<p>给定一组非负整数 <code>nums</code>，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。</p>
//
//<p><strong>注意：</strong>输出结果可能非常大，所以你需要返回一个字符串而不是整数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入<code>：</code></strong><code>nums = [10,2]</code>
//<strong>输出：</strong><code>"210"</code></pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入<code>：</code></strong><code>nums = [3,30,34,5,9]</code>
//<strong>输出：</strong><code>"9534330"</code>
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
//	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>排序</li></div></div><br><div><li>👍 929</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (o1, o2) -> {
            StringBuilder s1 = new StringBuilder(o1);
            StringBuilder s2 = new StringBuilder(o2);
            // 谁在前面可以让整体更大谁就大
            return -s1.append(o2).toString().compareTo(s2.append(o1).toString());
        });

        if (strings[0].equals("0")) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
