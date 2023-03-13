import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=366 lang=java
 *
 * [366] Find Leaves of Binary Tree
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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        return ans;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        int left = getHeight(node.left) + 1;
        int right = getHeight(node.right) + 1;
        int curHeight = Math.max(left, right);
        if (ans.size() == curHeight) {
            ans.add(new ArrayList<>());
        }
        ans.get(curHeight).add(node.val);
        return curHeight;
    }

}
// @lc code=end
