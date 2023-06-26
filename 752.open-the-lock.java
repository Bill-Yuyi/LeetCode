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
        int step = 0;
        String start = "0000";
        if (visited.contains("0000")) {
            return -1;
        }
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step - 1;
                }
                for (int j = 0; j < 4; j++) {
                    char c = cur.charAt(j);
                    String str1 = cur.substring(0, j) + (c == '0' ? "9" : c - 1 - '0') + cur.substring(j + 1);
                    String str2 = cur.substring(0, j) + (c == '9' ? "0" : c - '0' + 1) + cur.substring(j + 1);

                    if (!visited.contains(str2)) {
                        visited.add(str2);
                        queue.offer(str2);
                    }
                    if (!visited.contains(str1)) {
                        visited.add(str1);
                        queue.offer(str1);
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end
