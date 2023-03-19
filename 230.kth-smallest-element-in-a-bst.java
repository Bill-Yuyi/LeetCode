import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return list.get(k - 1);
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        list.add(node.val);
        traverse(node.right);
    }
}
// @lc code=end
