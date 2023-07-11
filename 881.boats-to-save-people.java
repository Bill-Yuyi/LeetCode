/*
 * @lc app=leetcode id=881 lang=java
 *
 * [881] Boats to Save People
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                res++;
                i++;
                j--;
            } else {
                res++;
                j--;
            }
        }
        return res;
    }
}
// @lc code=end
