package com.github;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    @Test
    public void tt() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), null));
        char[][] arr = new char[0][0];
        numIslands(arr);
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        // 因为所有元素长度都一样，不然要对每一个元素都获取一次长度。
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    removeIsland(grid, i, j);
                }
            }
        }
        return num;
    }

    private void removeIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        removeIsland(grid, i - 1, j);
        removeIsland(grid, i + 1, j);
        removeIsland(grid, i, j - 1);
        removeIsland(grid, i, j + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}