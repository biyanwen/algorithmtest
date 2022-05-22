package com.github;

import org.junit.jupiter.api.Test;

import java.util.*;

class Solution {
    @Test
    public void tt() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(5), null));


        int i = openLock(new String[]{"0201", "0101", "0102", "1212", "2002" }, "0202");
        System.out.println(i);
    }

    public int openLock(String[] deadends, String target) {
        if (Objects.equals(target, "0000")) {
            return 0;
        }
        Map<String, String> deadMap = new HashMap<>();
        for (String deadend : deadends) {
            deadMap.put(deadend, deadend);
        }
        if (deadMap.get("0000") != null) {
            return -1;
        }
        Map<String, String> usedMap = new HashMap<>();
        usedMap.put("0000", "0000");
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int num = 0;
        while (!queue.isEmpty()) {
            num++;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String poll = queue.poll();
                for (String element : getNextElementList(poll)) {
                    if (usedMap.get(element) == null && deadMap.get(element) == null) {
                        if (element.equals(target)) {
                            return num;
                        }
                        queue.offer(element);
                        usedMap.put(element, element);
                    }
                }
            }
        }
        return -1;
    }

    private Set<String> getNextElementList(String element) {
        Set<String> result = new HashSet<>();

        char[] chars = element.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            chars[i] = aChar == '9' ? '0' : (char) (aChar + 1);
            result.add(new String(chars));
            chars[i] = aChar == '0' ? '9' : (char) (aChar - 1);
            result.add(new String(chars));
            chars[i] = aChar;
        }
        return result;
    }
    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
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