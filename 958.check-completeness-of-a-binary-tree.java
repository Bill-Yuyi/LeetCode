import java.util.*;
/*
 * @lc app=leetcode id=958 lang=java
 *
 * [958] Check Completeness of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int last = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                if (p.index == last + 1) {
                    last = p.index;
                } else {

                    return false;
                }
                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * p.index));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * p.index + 1));
                }
            }
        }
        return true;
    }

    class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

}
// @lc code=end
