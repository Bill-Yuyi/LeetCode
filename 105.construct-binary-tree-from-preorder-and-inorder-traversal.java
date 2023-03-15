import java.util.*;
/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    int index = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[index];
        int rootPos = map.get(rootVal);
        TreeNode node = new TreeNode(rootVal);
        index++;
        node.left = build(preorder, start, rootPos - 1);
        node.right = build(preorder, rootPos + 1, end);
        return node;
    }
}
// @lc code=end
