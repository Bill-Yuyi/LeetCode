/*
 * @lc app=leetcode id=682 lang=java
 *
 * [682] Baseball Game
 */

// @lc code=start
class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for (String str : operations) {
            if (str.equals("+")) {
                int second = st.pop();
                int first = st.pop();
                int res = second + first;
                st.push(first);
                st.push(second);
                st.push(res);
            } else if (str.equals("C")) {
                st.pop();
            } else if (str.equals("D")) {
                st.push(st.peek() * 2);
            } else {
                st.push(Integer.valueOf(str));
            }
        }
        int sum = 0;
        for (int s : st) {
            sum += s;
        }
        return sum;
    }
}
// @lc code=end
