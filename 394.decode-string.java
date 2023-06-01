/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
import java.util.*;

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                stringStack.push(sb);
                num = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = sb;
                sb = stringStack.pop();
                int time = numStack.pop();
                for (int k = 0; k < time; k++) {
                    sb.append(tmp);
                }
            } else {
                sb.append(c);
            }
        }
        while (!stringStack.isEmpty()) {
            sb.append(stringStack.pop());
        }
        return sb.toString();
    }
}
// @lc code=end
