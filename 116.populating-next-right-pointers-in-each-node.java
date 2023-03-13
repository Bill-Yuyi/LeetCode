import java.util.*;
/*
 * @lc app=leetcode id=116 lang=java
 *
 * 
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        helper(root, null);
        return root;
    }

    public void helper(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        helper(left.left, left.right);
        if (right != null) {
            helper(left.right, right.left);
            helper(right.left, right.right);
        }
    }
}

// @lc code=end
