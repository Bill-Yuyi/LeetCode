/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    void build(TreeNode node, StringBuilder res) {
        if (node == null) {
            return;
        }

        res.append(node.val);
        if (node.left == null && node.right == null) {
            return;
        }

        res.append('(');
        build(node.left, res);
        res.append(')');

        if (node.right != null) {
            res.append('(');
            build(node.right, res);
            res.append(')');
        }
    }
}
// @lc code=end
