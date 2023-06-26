/*
 * @lc app=leetcode id=2462 lang=java
 *
 * [2462] Total Cost to Hire K Workers
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.cost == b.cost ? a.idx - b.idx : a.cost - b.cost));
        if (costs.length == 1) {
            return costs[0];
        }
        int i = 0, j = costs.length - 1;
        while (i < j && i < candidates) {
            pq.offer(new Pair(costs[i], i++));
        }
        while (i < j && j >= costs.length - candidates) {
            pq.offer(new Pair(costs[j], j--));
        }
        long ans = 0l;

        while (!pq.isEmpty() && i <= j && k != 0) {
            Pair cand = pq.poll();
            ans += cand.cost;
            // System.out.println(cand.cost + " " + cand.idx);
            if (Math.abs(cand.idx - i) > Math.abs(cand.idx - j)) {
                pq.offer(new Pair(costs[j], j--));
            } else {
                pq.offer(new Pair(costs[i], i++));
            }
            k--;
        }

        while (!pq.isEmpty() && k != 0) {
            Pair cand = pq.poll();
            // System.out.println(cand.cost + " " + cand.idx);
            ans += cand.cost;
            k--;
        }
        return ans;

    }
}

class Pair {
    int cost;
    int idx;

    Pair(int cost, int idx) {
        this.cost = cost;
        this.idx = idx;
    }
}
// @lc code=end
