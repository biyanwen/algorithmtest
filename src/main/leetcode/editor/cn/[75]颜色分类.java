//<p>给定一个包含红色、白色和蓝色、共&nbsp;<code>n</code><em> </em>个元素的数组<meta charset="UTF-8" />&nbsp;<code>nums</code>&nbsp;，<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank">原地</a></strong>对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。</p>
//
//<p>我们使用整数 <code>0</code>、&nbsp;<code>1</code> 和 <code>2</code> 分别表示红色、白色和蓝色。</p>
//
//<ul>
//</ul>
//
//<p>必须在不使用库的sort函数的情况下解决这个问题。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,0,2,1,1,0]
//<strong>输出：</strong>[0,0,1,1,2,2]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,0,1]
//<strong>输出：</strong>[0,1,2]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>n == nums.length</code></li>
//	<li><code>1 &lt;= n &lt;= 300</code></li>
//	<li><code>nums[i]</code> 为 <code>0</code>、<code>1</code> 或 <code>2</code></li>
//</ul>
//
//<p>&nbsp;</p>
//
//<p><strong>进阶：</strong></p>
//
//<ul>
//	<li>你可以不使用代码库中的排序函数来解决这道题吗？</li>
//	<li>你能想出一个仅使用常数空间的一趟扫描算法吗？</li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1271</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // [0,p0) => 0
    // [p0,p1] => 1
    // (p1,nums.length - 1) => 2
/*
	定义双指针，左指针左边元素都是0，右指针右边元素都是2，遍历原始数组；
	如果是0则跟左指针交换，左指针向右；
	如果是2则跟右指针交换，右指针向左；
	左指针从原始数组左边开始，右指针从原始数组右边开始；
	元素为2时，与右指针交换元素，原右指针指向的元素尚未遍历，此时i不能动；
*/
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
