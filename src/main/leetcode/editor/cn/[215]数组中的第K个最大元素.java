//<p>给定整数数组 <code>nums</code> 和整数 <code>k</code>，请返回数组中第 <code><strong>k</strong></code> 个最大的元素。</p>
//
//<p>请注意，你需要找的是数组排序后的第 <code>k</code> 个最大的元素，而不是第 <code>k</code> 个不同的元素。</p>
//
//<p> </p>
//
//<p><strong>示例 1:</strong></p>
//
//<pre>
//<strong>输入:</strong> <code>[3,2,1,5,6,4] 和</code> k = 2
//<strong>输出:</strong> 5
//</pre>
//
//<p><strong>示例 2:</strong></p>
//
//<pre>
//<strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6] 和</code> k = 4
//<strong>输出:</strong> 4</pre>
//
//<p> </p>
//
//<p><strong>提示： </strong></p>
//
//<ul>
//	<li><code>1 <= k <= nums.length <= 10<sup>4</sup></code></li>
//	<li><code>-10<sup>4</sup> <= nums[i] <= 10<sup>4</sup></code></li>
//</ul>
//<div><div>Related Topics</div><div><li>数组</li><li>分治</li><li>快速选择</li><li>排序</li><li>堆（优先队列）</li></div></div><br><div><li>👍 1669</li><li>👎 0</li></div>

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        int length = nums.length;
        int result = -Integer.MAX_VALUE;
        // 不断弹出堆顶的元素
        //1 拿出堆顶元素
        //2 并将最后一个元素放到堆顶
        //3 从堆顶进行下沉操作
        for (int i = 0; i < k; i++) {
            result = nums[0];
            nums[0] = nums[length - 1];
            length--;
            buildMaxHeap(nums, 0, length);
        }
        return result;
    }

    public void sort(int[] nums) {
        int length = nums.length;
        for (int indexOfParent = (length / 2); indexOfParent >= 0; indexOfParent--) {

            // 创建最大堆
            //1 indexOfParent = (length / 2) 拿到最后一个非叶子节点（最后一个父节点）
            //2 做下沉操作
            //3 递归下沉，因为可能从父节点换下来的元素比后面的元素更小
            buildMaxHeap(nums, indexOfParent, length);
        }
    }

    private void buildMaxHeap(int[] nums, int indexOfParent, int length) {
        int leftChild = 2 * indexOfParent + 1;
        int rightChild = 2 * indexOfParent + 2;
        int largerIndex = indexOfParent;
        if (leftChild < length && nums[largerIndex] < nums[leftChild]) {
            largerIndex = leftChild;
        }
        if (rightChild < length && nums[largerIndex] < nums[rightChild]) {
            largerIndex = rightChild;
        }
        if (largerIndex != indexOfParent) {
            swap(nums, largerIndex, indexOfParent);
            buildMaxHeap(nums, largerIndex, length);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
