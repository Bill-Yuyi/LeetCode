/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int leftmost = 0, rightmost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            leftmost = 0;
            rightmost = 0;
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (leftmost == 0) {
                    leftmost = cur.idx;
                } else {
                    rightmost = cur.idx;
                }
                if (cur.node.left != null) {
                    queue.offer(new Pair(cur.node.left, cur.idx * 2));
                }
                if (cur.node.right != null) {
                    queue.offer(new Pair(cur.node.right, cur.idx * 2 + 1));
                }
            }
            if (leftmost == 0 && rightmost == 0) {
                continue;
            }
            max = Math.max(max, rightmost == 0 ? 1 : rightmost - leftmost + 1);

        }
        return max;
    }
}

class Pair {
    TreeNode node;
    int idx;

    Pair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}
// @lc code=end
