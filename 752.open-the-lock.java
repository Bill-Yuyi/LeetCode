/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start

import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains(target) || visited.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    char c = cur.charAt(j);
                    String s1 = cur.substring(0, j) + (c == '0' ? "9" : (c - '0' - 1)) + cur.substring(j + 1);
                    String s2 = cur.substring(0, j) + (c == '9' ? "0" : (c - '0' + 1)) + cur.substring(j + 1);
                    if (!visited.contains(s1)) {
                        visited.add(s1);
                        queue.offer(s1);
                    }
                    if (!visited.contains(s2)) {
                        visited.add(s2);
                        queue.offer(s2);
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
// @lc code=end
