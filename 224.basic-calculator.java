/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0, res = 0, sign = 1;
        char c = '1';
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);

                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                res *= st.pop();
                res += st.pop();
                num = 0;
            }
        }

        return res + (sign * num);
    }
}
// @lc code=end
