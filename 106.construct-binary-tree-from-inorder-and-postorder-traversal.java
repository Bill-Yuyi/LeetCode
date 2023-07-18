import java.util.HashMap;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int pos = map.get(rootVal);
        int rightSize = inEnd - pos;
        TreeNode node = new TreeNode(rootVal);
        node.left = build(postorder, inStart, pos - 1, postEnd - rightSize - 1);
        node.right = build(postorder, pos + 1, inEnd, postEnd - 1);
        return node;

    }

}
// @lc code=end
