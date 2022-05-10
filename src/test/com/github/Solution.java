package com.github;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] result = null;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					result = new int[]{
							i, j
					};
				}
			}
		}
		return result;
	}
}