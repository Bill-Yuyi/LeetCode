/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder cur = new StringBuilder(queue.poll());
                if (cur.toString().equals(endWord)) {
                    return step;
                }
                for (int j = 0; j < cur.length(); j++) {
                    char c = cur.charAt(j);
                    for (char a = 'a'; a <= 'z'; a++) {
                        cur.setCharAt(j, a);
                        String changed = cur.toString();

                        if (wordSet.contains(changed) && !visited.contains(changed)) {
                            queue.offer(changed);
                            visited.add(changed);
                            // System.out.println(step + " " + changed);
                        }
                    }
                    cur.setCharAt(j, c);
                }
            }
            step++;
        }

        return 0;
    }
}
// @lc code=end
