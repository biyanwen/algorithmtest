//<p>给你一个包含 <code>n</code> 个整数的数组 <code>nums</code>，判断 <code>nums</code> 中是否存在三个元素 <em>a，b，c ，</em>使得 <em>a + b + c = </em>0 ？请你找出所有和为 <code>0</code> 且不重复的三元组。</p>
//
//<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
//<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0]
//<strong>输出：</strong>[]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>0 <= nums.length <= 3000</code></li>
//	<li><code>-10<sup>5</sup> <= nums[i] <= 10<sup>5</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 4758</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int a = 0; a < length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int c = length - 1;
            for (int b = a + 1; b < length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                //如果 nums[b] + nums[c] > -nums[a] 说明结果大了，需要 c 指针左移让其减小，反之 b 指针右移让结果增大
                while (b < c && nums[b] + nums[c] > -nums[a]) {
                    c--;
                }
                // 再循环就重复了
                if (b == c) {
                    break;
                }

                if (nums[b] + nums[c] == -nums[a]) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[a]);
                    tmpList.add(nums[b]);
                    tmpList.add(nums[c]);
                    result.add(tmpList);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
