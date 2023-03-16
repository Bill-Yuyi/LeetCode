import java.util.*;
/*
 * @lc app=leetcode id=652 lang=java
 *
 * [652] Find Duplicate Subtrees
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
    HashMap<String, List<TreeNode>> map;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        traverse(root);
        for (List<TreeNode> list : map.values()) {
            if (list.size() > 1) {
                ans.add(list.get(0));
            }
        }
        return ans;
    }

    public String traverse(TreeNode node) {
        if (node == null) {
            return "";
        }
        String key = "(" + traverse(node.left) + node.val + traverse(node.right) + ")";
        map.computeIfAbsent(key, val -> new ArrayList<>()).add(node);
        return key;
    }
}
// @lc code=end
