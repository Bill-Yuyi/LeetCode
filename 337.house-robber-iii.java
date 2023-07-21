/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start

import java.util.Queue;

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
import java.util.*;

class Solution {
    HashMap<TreeNode, Integer> robbed = new HashMap<>();
    HashMap<TreeNode, Integer> notRobbed = new HashMap<>();

    public int rob(TreeNode root) {
        return traverse(root, false);
    }

    public int traverse(TreeNode node, boolean parentRobbed) {
        if (node == null) {
            return 0;
        }
        if (parentRobbed) {
            if (robbed.containsKey(node)) {
                return robbed.get(node);
            }
            int res = traverse(node.left, false) + traverse(node.right, false);
            robbed.put(node, res);
            return res;
        } else {
            if (notRobbed.containsKey(node)) {
                return notRobbed.get(node);
            }
            int robRes = node.val + traverse(node.left, true) + traverse(node.right, true);
            int notRes = traverse(node.left, false) + traverse(node.right, false);
            notRobbed.put(node, Math.max(notRes, robRes));
            return Math.max(robRes, notRes);
        }
    }
}
// @lc code=end
