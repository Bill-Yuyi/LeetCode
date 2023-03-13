import java.util.HashMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    DoubleLinkedList list;
    int k;
    HashMap<Integer, DoubleLinkedListNode> map;

    public LRUCache(int capacity) {
        list = new DoubleLinkedList();
        k = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            delete(key);
        }
        if (list.getSize() == k) {
            removeLeastUsed();
        }
        addRecently(key, value);
    }

    private void makeRecently(int key) {
        DoubleLinkedListNode node = map.get(key);
        list.remove(node);
        list.addLast(node);
    }

    public void delete(int key) {
        DoubleLinkedListNode node = map.get(key);
        map.remove(key);
        list.remove(node);
    }

    public void addRecently(int key, int val) {
        DoubleLinkedListNode node = new DoubleLinkedListNode(key, val);
        map.put(key, node);
        list.addLast(node);
    }

    public void removeLeastUsed() {
        DoubleLinkedListNode toRemove = list.removeFront();
        map.remove(toRemove.key);
    }
}

class DoubleLinkedListNode {
    public int key, val;
    public DoubleLinkedListNode next, prev;

    DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoubleLinkedList {
    public DoubleLinkedListNode head, tail;
    public int size;

    DoubleLinkedList() {
        this.head = new DoubleLinkedListNode(0, 0);
        this.tail = new DoubleLinkedListNode(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(DoubleLinkedListNode x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    public void remove(DoubleLinkedListNode x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public DoubleLinkedListNode removeFront() {
        if (head.next == tail) {
            return null;
        }
        DoubleLinkedListNode first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
