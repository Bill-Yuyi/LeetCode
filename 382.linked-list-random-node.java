import java.util.Random;

/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
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
    ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        Random r = new Random();
        int res = 0, i = 0;
        ListNode p = head;
        while (p != null) {
            if (r.nextInt(++i) == 0) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end
