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
        return build(preorder, inorder, 0, inorder.length - 1);

    }

    TreeNode build(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preorder[index++];
        int pos = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(preorder, inorder, start, pos - 1);
        node.right = build(preorder, inorder, pos + 1, end);
        return node;
    }

}
// @lc code=end
