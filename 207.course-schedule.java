import java.util.*;
/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int num, int[][] pres) {
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
                canFinish++;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (map.containsKey(cur)) {
                for (int course : map.get(cur)) {
                    indegree[course]--;
                    if (indegree[course] == 0) {
                        queue.offer(course);
                        canFinish++;
                    }
                }
            }
        }
        return canFinish == num;

    }
}
// @lc code=end
