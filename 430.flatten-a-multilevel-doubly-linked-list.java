/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null || head.next == null && head.child == null) {
            return head;
        }
        if (head.child == null) {
            Node a = flatten(head.next);
            a.prev = head;
            head.next = a;
            return head;
        }
        Node temp = head.next;
        Node after = flatten(head.child);
        Node cur = after;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        cur.next = temp;
        if (temp != null) {
            temp.prev = cur;
        }
        head.next = after;
        after.prev = head;
        head.child = null;
        return head;
    }
}

// @lc code=end
