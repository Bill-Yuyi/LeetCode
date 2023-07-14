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
        return build(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);

    }

    TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }
        int val = postorder[postEnd];
        int pos = map.get(val);
        int rightsize = inEnd - pos;
        TreeNode node = new TreeNode(val, build(inorder, inStart, pos - 1, postorder, postEnd - rightsize - 1),
                build(inorder, pos + 1, inEnd, postorder, postEnd - 1));
        return node;
    }

}
// @lc code=end
