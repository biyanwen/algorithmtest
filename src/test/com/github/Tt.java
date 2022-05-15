package com.github;

import org.junit.jupiter.api.Test;

public class Tt {

	@Test
	public void t() {
		System.out.println(reverse(123));
	}

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
