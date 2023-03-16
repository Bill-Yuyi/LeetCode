import java.util.*;
/*
 * @lc app=leetcode id=1466 lang=java
 *
 * [1466] Reorder Routes to Make All Paths Lead to the City Zero
 */

// @lc code=start
class Solution {
    public int minReorder(int n, int[][] edges) {
        int res = 0;
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(new int[] { edge[1], 1 });
            map.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(new int[] { edge[0], 0 });
        }
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.containsKey(cur)) {
                for (int[] next : map.get(cur)) {
                    if (!visited[next[0]]) {
                        res += next[1];
                        queue.offer(next[0]);
                        visited[next[0]] = true;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end
