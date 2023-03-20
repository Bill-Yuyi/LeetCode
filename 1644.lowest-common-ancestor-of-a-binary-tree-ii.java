/*
 * @lc app=leetcode id=1644 lang=java
 *
 * [1644] Lowest Common Ancestor of a Binary Tree II
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
    boolean findQ = false, findP = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode res = find(root, p, q);
        // if p and q are all found,return res
        return findP && findQ ? res : null;
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // since there might be nodes not existed, using postorder to search throughout
        // the tree
        // record boolean if find p or q
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val)
                findP = true;
            if (root.val == q.val)
                findQ = true;
            return root;
        }
        return left == null ? right : left;
    }
}
// @lc code=end
