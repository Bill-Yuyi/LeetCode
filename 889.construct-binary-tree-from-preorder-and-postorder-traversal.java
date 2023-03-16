import java.util.HashMap;

/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    HashMap<Integer, Integer> map;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            map.put(postorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        int rootVal = preorder[preStart];
        int pos = map.get(preorder[preStart + 1]);
        // +1 since we havent actually used preorder[preStart + 1]
        int leftSize = pos - postStart + 1;
        TreeNode node = new TreeNode(rootVal);
        node.left = buildTree(preorder, preStart + 1, preStart + leftSize, postorder, postStart, pos);
        node.right = buildTree(preorder, preStart + leftSize + 1, preEnd, postorder, pos + 1, postEnd - 1);
        return node;
    }
}
// @lc code=end
