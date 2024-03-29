/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[] { 0 };
        maxDepth(root, max);
        return max[0];
    }

    int maxDepth(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);
        max[0] = Math.max(left + right, max[0]);
        return Math.max(left, right) + 1;
    }

}
// @lc code=end
