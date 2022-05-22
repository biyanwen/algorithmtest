package com.github;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    @Test
    public void tt() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), null));


    }


    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        List<Reduction> reductionList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            fill(board, 0, i, reductionList);
            fill(board, n - 1, i, reductionList);
        }
        for (int i = 0; i < n; i++) {
            fill(board, i, 0, reductionList);
            fill(board, i - 1, 0, reductionList);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fill(board, i, j, new ArrayList<>());
            }
        }
        for (Reduction reduction : reductionList) {
            board[reduction.i][reduction.j] = 'O';
        }
    }

    private void fill(char[][] board, int i, int j, List<Reduction> reductionList) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'X') {
            return;
        }
        board[i][j] = 'O';
        reductionList.add(new Reduction(i, j));
        fill(board, i - 1, j, reductionList);
        fill(board, i + 1, j, reductionList);
        fill(board, i + 1, j - 1, reductionList);
        fill(board, i + 1, j + 1, reductionList);
    }

    private static class Reduction {
        private int i;
        private int j;

        public Reduction(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
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