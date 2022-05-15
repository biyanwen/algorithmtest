package com.github;

import org.junit.jupiter.api.Test;

public class Tt {

	@Test
	public void t() {
		int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int i = maxSubArray(array);
		System.out.println(i);
	}

	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		Integer max = null;
		Integer sum = null;
		for (int num : nums) {
			if (sum == null) {
				max = num;
				sum = num;
				// 负数直接抛弃，因为加上一个负数一定比之前更小
			} else if (sum < 0) {
				sum = num;
			} else {
				sum += num;
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}
