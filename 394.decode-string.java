/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
import java.util.*;

class Solution {
    public String decodeString(String s) {
        StringBuilder curString = new StringBuilder();
        int curnum = 0;
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curnum = curnum * 10 + c - '0';
            } else if (c == '[') {
                numStack.push(curnum);
                stringStack.push(curString);
                curnum = 0;
                curString = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = curString;
                curString = stringStack.pop();
                for (int k = numStack.pop(); k > 0; k--) {
                    curString.append(tmp);
                }
            } else {
                curString.append(c);
            }
        }

        while (!stringStack.isEmpty()) {
            curString.append(stringStack.pop());
        }
        return curString.toString();
    }
}
// @lc code=end
