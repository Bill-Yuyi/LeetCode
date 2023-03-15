import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    public void traverse(TreeNode node, int cur) {
        if (node == null) {
            return;
        }
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
            return;
        }
        traverse(node.left, cur);
        traverse(node.right, cur);

    }
}
// @lc code=end
