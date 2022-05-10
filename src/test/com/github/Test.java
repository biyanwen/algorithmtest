package com.github;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3};
		core(array);
	}

	private static void core(int[] array) {
		int length = array.length;
		fullArray(array, 0, length - 1);
	}

	private static void fullArray(int[] array, int cursor, int end) {
		if (cursor == end) {
			System.out.println(Arrays.toString(array));
		} else {
			for (int i = cursor; i <= end; i++) {
				swap(array, cursor, i);
				fullArray(array, cursor + 1, end);
			}
		}
	}

	private static void swap(int[] array, int cursor, int end) {
		int tmp = array[cursor];
		array[cursor] = array[end];
		array[end] = tmp;
	}

}
