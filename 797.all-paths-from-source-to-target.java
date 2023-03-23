import java.util.*;
/*
 * @lc app=leetcode id=797 lang=java
 *
 * [797] All Paths From Source to Target
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        backtrack(0, graph.length - 1, graph);
        return ans;
    }

    public void backtrack(int source, int dest, int[][] graph) {
        path.add(source);
        if (source == dest) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[source]) {

            backtrack(next, dest, graph);
            path.remove(path.size() - 1);
        }
    }

}
// @lc code=end
