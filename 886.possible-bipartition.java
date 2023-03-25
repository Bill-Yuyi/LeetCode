import java.util.*;
/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
    boolean[] visited;
    boolean[] color;
    boolean isBiGraph = true;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            map.computeIfAbsent(dislike[0], val -> new ArrayList<>()).add(dislike[1]);
            map.computeIfAbsent(dislike[1], val -> new ArrayList<>()).add(dislike[0]);
        }
        for (int i = 1; i < n + 1; i++) {
            dfs(map, i);
        }
        return isBiGraph;
    }

    public void dfs(HashMap<Integer, List<Integer>> map, int i) {
        if (!isBiGraph) {
            return;
        }
        visited[i] = true;
        if (map.containsKey(i)) {
            for (int next : map.get(i)) {
                if (!visited[next]) {
                    color[next] = !color[i];
                    dfs(map, next);
                } else {
                    if (color[next] == color[i]) {
                        isBiGraph = false;
                        return;
                    }
                }
            }
        }
    }
}
// @lc code=end
