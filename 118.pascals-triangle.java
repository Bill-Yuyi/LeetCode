/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = ans.get(i - 1);
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            for (int j = 1; j < i; j++) {
                curRow.add(pre.get(j - 1) + pre.get(j));
            }
            curRow.add(1);
            ans.add(new ArrayList<>(curRow));
        }
        return ans;
    }
}
// @lc code=end
