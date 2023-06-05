/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class Solution {

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root);
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(target.val);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        while (!queue.isEmpty() && step <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (step == k) {
                    ans.add(cur);
                    continue;
                }
                if (graph.containsKey(cur)) {
                    for (int next : graph.get(cur)) {
                        if (visited.contains(next)) {
                            continue;
                        }
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return ans;
    }

    void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (node.left != null) {
            graph.computeIfAbsent(node.val, val -> new ArrayList<>()).add(node.left.val);
            graph.computeIfAbsent(node.left.val, val -> new ArrayList<>()).add(node.val);
        }
        if (node.right != null) {
            graph.computeIfAbsent(node.val, val -> new ArrayList<>()).add(node.right.val);
            graph.computeIfAbsent(node.right.val, val -> new ArrayList<>()).add(node.val);
        }
        traverse(node.right);
    }
}
// @lc code=end
