public class DoubleLinkedList {
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
