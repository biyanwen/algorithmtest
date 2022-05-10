package com.github;

import java.util.Arrays;

//归并排序，时间复杂度为O(N*logN)，空间复杂度为O(N)
public class MergeSort {
	public static void MergeSort(int[] arr, int startIndex, int endIndex) {
		//分治的结束条件
		if (startIndex >= endIndex) {
			return;
		}
		//保证不溢出取start和end的中位数
		int mid = startIndex + ((endIndex - startIndex) >> 1);
		//递归排序并且合并
		MergeSort(arr, startIndex, mid);
		MergeSort(arr, mid + 1, endIndex);
		Merge(arr, startIndex, mid, endIndex);
	}

	//合并
	public static void Merge(int[] arr, int startIndex, int midIndex, int endIndex) {
		int[] temp = new int[endIndex - startIndex + 1];
		int startIndexCopy = startIndex;
		int midIndexCopy = midIndex + 1;
		int currentIndex = 0;
		while (startIndexCopy <= midIndex && midIndexCopy <= endIndex) {
			int startValue = arr[startIndexCopy];
			int midValue = arr[midIndexCopy];
			if (startValue > midValue) {
				temp[currentIndex++] = arr[midIndexCopy++];
			} else {
				temp[currentIndex++] = arr[startIndexCopy++];
			}
		}
		while (startIndexCopy <= midIndex) {
			temp[currentIndex++] = arr[startIndexCopy++];
		}
		while (midIndexCopy <= endIndex) {
			temp[currentIndex++] = arr[midIndexCopy++];
		}
		for (int i = 0; i < temp.length; i++) {
			arr[i + startIndex] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] a = {5, 3, 2, 6, 1, 9, 8, 10};
		MergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
}