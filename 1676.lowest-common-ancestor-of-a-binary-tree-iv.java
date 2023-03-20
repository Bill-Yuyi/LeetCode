import java.util.HashSet;

/*
 * @lc app=leetcode id=1676 lang=java
 *
 * [1676] Lowest Common Ancestor of a Binary Tree IV
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
class Solution {
    // same as 236,just adding a set to store value of nodes
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return find(root, set);
    }

    private TreeNode find(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return null;
        }
        if (set.contains(node.val)) {
            return node;
        }
        TreeNode left = find(node.left, set);
        TreeNode right = find(node.right, set);
        if (left != null && right != null) {
            return node;
        }
        return left == null ? right : left;
    }
}
// @lc code=end
