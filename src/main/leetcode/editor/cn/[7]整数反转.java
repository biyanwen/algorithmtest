//<p>给你一个 32 位的有符号整数 <code>x</code> ，返回将 <code>x</code> 中的数字部分反转后的结果。</p>
//
//<p>如果反转后整数超过 32 位的有符号整数的范围 <code>[−2<sup>31</sup>,  2<sup>31 </sup>− 1]</code> ，就返回 0。</p>
//<strong>假设环境不允许存储 64 位整数（有符号或无符号）。</strong>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 123
//<strong>输出：</strong>321
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = -123
//<strong>输出：</strong>-321
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 120
//<strong>输出：</strong>21
//</pre>
//
//<p><strong>示例 4：</strong></p>
//
//<pre>
//<strong>输入：</strong>x = 0
//<strong>输出：</strong>0
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>-2<sup>31</sup> <= x <= 2<sup>31</sup> - 1</code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 3510</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //1、跟10取余数，这样每次能拿到最后一位数字。
    //2、当前余数 *10 加上下一个余数这样就翻转了。
    //3、每次循环 x /= 10 这样可以去除已经使用过的元素。
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int remainder = x % 10;
            result = result * 10 + remainder;
            x /= 10;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
