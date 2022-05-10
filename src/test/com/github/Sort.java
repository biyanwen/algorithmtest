package com.github;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Sort {

	@Test
	public void te() {
		int[] a = {5, 3, 2, 6, 1, 9, 8, 10};
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private void sort(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int midIndex = (endIndex - startIndex) / 2 + startIndex;
		sort(array, startIndex, midIndex);
		sort(array, midIndex + 1, endIndex);
		merge(array, startIndex, midIndex, endIndex);
	}

	private void merge(int[] array, int startIndex, int midIndex, int endIndex) {
		int[] tmp = new int[endIndex - startIndex + 1];
		int starIndexCopy = startIndex;
		int midIndexCopy = midIndex + 1;
		int currentIndex = 0;

		while (starIndexCopy <= midIndex && midIndexCopy <= endIndex) {
			int startIndexValue = array[starIndexCopy];
			int midIndexValue = array[midIndexCopy];
			if (startIndexValue <= midIndexValue) {
				tmp[currentIndex] = startIndexValue;
				starIndexCopy += 1;
			} else {
				tmp[currentIndex] = midIndexValue;
				midIndexCopy += 1;
			}
			currentIndex += 1;
		}
		while (starIndexCopy <= midIndex) {
			tmp[currentIndex] = array[starIndexCopy];
			currentIndex += 1;
			starIndexCopy += 1;
		}
		while (midIndexCopy <= endIndex) {
			tmp[currentIndex] = array[midIndexCopy];
			currentIndex += 1;
			midIndexCopy += 1;
		}
		System.arraycopy(tmp, 0, array, startIndex, tmp.length);
	}
}
