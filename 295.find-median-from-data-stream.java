/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    boolean isEven = true;

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (isEven) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (!isEven) {
            return (double) maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end
