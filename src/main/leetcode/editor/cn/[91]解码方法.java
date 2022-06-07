//<p>一条包含字母&nbsp;<code>A-Z</code> 的消息通过以下映射进行了 <strong>编码</strong> ：</p>
//
//<pre>
//'A' -&gt; "1"
//'B' -&gt; "2"
//...
//'Z' -&gt; "26"</pre>
//
//<p>要 <strong>解码</strong> 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，<code>"11106"</code> 可以映射为：</p>
//
//<ul>
//	<li><code>"AAJF"</code> ，将消息分组为 <code>(1 1 10 6)</code></li>
//	<li><code>"KJF"</code> ，将消息分组为 <code>(11 10 6)</code></li>
//</ul>
//
//<p>注意，消息不能分组为&nbsp; <code>(1 11 06)</code> ，因为 <code>"06"</code> 不能映射为 <code>"F"</code> ，这是由于 <code>"6"</code> 和 <code>"06"</code> 在映射中并不等价。</p>
//
//<p>给你一个只含数字的 <strong>非空 </strong>字符串 <code>s</code> ，请计算并返回 <strong>解码</strong> 方法的 <strong>总数</strong> 。</p>
//
//<p>题目数据保证答案肯定是一个 <strong>32 位</strong> 的整数。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "12"
//<strong>输出：</strong>2
//<strong>解释：</strong>它可以解码为 "AB"（1 2）或者 "L"（12）。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "226"
//<strong>输出：</strong>3
//<strong>解释：</strong>它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "0"
//<strong>输出：</strong>0
//<strong>解释：</strong>没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -&gt; "10" 和 'T'-&gt; "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 &lt;= s.length &lt;= 100</code></li>
//	<li><code>s</code> 只包含数字，并且可能包含前导零。</li>
//</ul>
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 1184</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // db[i] = db[i - 1] + db[i - 2]
    // 解释：当 db[i] 自己解码时 db[i] = db[i - 1]
    //当 db[i] 与前面的元素一起解码时 db[i] = db[i - 2]
    //因为两种情况是独立存在的，所以结果就是 db[i] = db[i - 1] + db[i - 2]

    //重要！！！ 本代码的 i 指的是从 0 开始的索引，而官网代码的意思是从 1 开始的索引。
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] db = new int[length];
        if (chars[0] == '0') {
            return 0;
        }
        if (chars.length == 1) {
            return 1;
        }
        db[0] = 1;

        for (int i = 1; i < length; i++) {
            if (chars[i] != '0') {
                db[i] += db[i - 1];
            }
            if (chars[i - 1] != '0' && Integer.parseInt(chars[i - 1] + "" + chars[i] + "") <= 26) {
                if (i == 1) {
                    db[i] += 1;
                } else {
                    db[i] += db[i - 2];
                }
            }
        }
        return db[length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
