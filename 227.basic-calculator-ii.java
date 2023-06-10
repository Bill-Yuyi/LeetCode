/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        char op = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isWhitespace(c) && !Character.isDigit(c) || i == s.length() - 1) {
                if (op == '+') {
                    st.push(num);
                } else if (op == '-') {
                    st.push(-num);
                } else if (op == '*') {
                    st.push(st.pop() * num);
                } else {
                    st.push(st.pop() / num);
                }

                num = 0;
                op = c;
            }
        }
        int res = 0;
        for (Integer val : st) {
            res += val;
        }
        return res;

    }
}
// @lc code=end
