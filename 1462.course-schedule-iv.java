/*
 * @lc app=leetcode id=1462 lang=java
 *
 * [1462] Course Schedule IV
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] p, int[][] queries) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        HashMap<Integer, Set<Integer>> pMap = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] e : p) {
            map.computeIfAbsent(e[0], val -> new HashSet<>()).add(e[1]);
            indegree[e[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (map.containsKey(node)) {
                for (int next : map.get(node)) {
                    pMap.computeIfAbsent(next, val -> new HashSet<>()).add(node);
                    if (pMap.containsKey(node)) {
                        pMap.get(next).addAll(pMap.get(node));
                    }
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        for (int[] q : queries) {
            if (pMap.containsKey(q[1]) && pMap.get(q[1]).contains(q[0])) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}
// @lc code=end
