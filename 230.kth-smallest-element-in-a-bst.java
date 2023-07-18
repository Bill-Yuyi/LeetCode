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

    public int kthSmallest(TreeNode root, int k) {
        int[] pos = new int[] { 0, 0 };
        traverse(root, pos, k);
        return pos[1];
    }

    void traverse(TreeNode node, int[] pos, int k) {
        if (node == null) {
            return;
        }
        traverse(node.left, pos, k);
        pos[0] += 1;
        if (pos[0] == k) {
            pos[1] = node.val;
            return;
        }
        traverse(node.right, pos, k);

    }

}
// @lc code=end
