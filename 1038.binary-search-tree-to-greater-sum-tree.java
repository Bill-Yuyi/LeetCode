import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1038 lang=java
 *
 * [1038] Binary Search Tree to Greater Sum Tree
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
    List<Integer> list = new ArrayList<>();
    int index = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        for (int i = list.size() - 2; i >= 0; i--) {
            list.set(i, list.get(i + 1) + list.get(i));
        }
        buildTree(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    public void buildTree(TreeNode root) {
        if (root == null) {
            return;
        }
        buildTree(root.left);
        root.val = list.get(index++);
        buildTree(root.right);

    }
}
// @lc code=end
