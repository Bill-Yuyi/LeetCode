import java.util.*;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int num, int[][] pres) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[num];
        for (int[] pre : pres) {
            map.computeIfAbsent(pre[1], val -> new ArrayList<>()).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int canFinish = 0;
        for (int i = 0; i < num; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                canFinish++;
            }
        }
        int[] res = new int[num];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index++] = cur;
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                        canFinish++;
                    }
                }
            }
        }
        return canFinish == num ? res : new int[0];
    }
}
// @lc code=end
