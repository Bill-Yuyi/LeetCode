import java.util.*;
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

class Solution {
    public boolean canFinish(int num, int[][] pres) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[num];
        for (int[] p : pres) {
            graph.computeIfAbsent(p[1], val -> new ArrayList<>()).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int finish = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                finish++;
                queue.offer(i);
            }
        }
        if (finish == 0) {
            return false;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (graph.containsKey(cur)) {
                    for (int next : graph.get(cur)) {

                        indegree[next]--;
                        if (indegree[next] == 0) {
                            queue.offer(next);
                            finish++;
                        }
                    }
                }
            }
        }

        return finish == num;
    }
}
// @lc code=end
