//<p>给定一个未经排序的整数数组，找到最长且<strong> 连续递增的子序列</strong>，并返回该序列的长度。</p>
//
//<p><strong>连续递增的子序列</strong> 可以由两个下标 <code>l</code> 和 <code>r</code>（<code>l < r</code>）确定，如果对于每个 <code>l <= i < r</code>，都有 <code>nums[i] < nums[i + 1]</code> ，那么子序列 <code>[nums[l], nums[l + 1], ..., nums[r - 1], nums[r]]</code> 就是连续递增子序列。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,3,5,4,7]
//<strong>输出：</strong>3
//<strong>解释：</strong>最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,2,2,2,2]
//<strong>输出：</strong>1
//<strong>解释：</strong>最长连续递增序列是 [2], 长度为1。
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= nums.length <= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li></div></div><br><div><li>👍 288</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        int start = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
