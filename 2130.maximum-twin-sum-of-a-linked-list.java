/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode left;
    int sum = Integer.MIN_VALUE;

    public int pairSum(ListNode head) {
        left = head;
        traverse(head);
        return sum;
    }

    public void traverse(ListNode right) {
        if (right == null)
            return;
        traverse(right.next);
        sum = Math.max(left.val + right.val, sum);
        left = left.next;
    }
}
// @lc code=end
