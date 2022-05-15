package com.github;

import org.junit.jupiter.api.Test;

class Solution {
    @Test
    public void test() {
        int reverse = reverse(-1);
        System.out.println(reverse);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}