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
        traverse(root, new TreeNode(-1));
        int val = target.val;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(val);
        Set<Integer> visited = new HashSet<>();
        visited.add(val);
        int count = 0;

        while (!queue.isEmpty() && count < k + 1) {
            int size = queue.size();
            ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ans.add(cur);
                if (graph.containsKey(cur)) {
                    for (int next : graph.get(cur)) {
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            count++;
        }
        return count == k + 1 ? ans : new ArrayList<>();

    }

    private void traverse(TreeNode cur, TreeNode prev) {
        if (cur == null || prev == null) {
            return;
        }
        traverse(cur.left, cur);
        if (prev.val != -1) {
            graph.computeIfAbsent(cur.val, k -> new ArrayList<>()).add(prev.val);
            graph.computeIfAbsent(prev.val, k -> new ArrayList<>()).add(cur.val);
        }

        traverse(cur.right, cur);
    }
}
// @lc code=end
