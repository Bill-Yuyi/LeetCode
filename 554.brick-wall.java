/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int pos = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                pos += wall.get(i).get(j);
                map.put(pos, map.getOrDefault(pos, 0) + 1);
            }
        }
        int res = wall.size();
        if (!map.isEmpty()) {
            res -= Collections.max(map.values());
        }
        return res;
    }
}
// @lc code=end
