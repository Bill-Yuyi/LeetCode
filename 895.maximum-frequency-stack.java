/*
 * @lc app=leetcode id=895 lang=java
 *
 * [895] Maximum Frequency Stack
 */

// @lc code=start
import java.util.*;

class FreqStack {
    Map<Integer, Integer> kf;
    Map<Integer, Stack<Integer>> ks;
    int maxFreq;

    public FreqStack() {
        kf = new HashMap<>();
        ks = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int key) {
        kf.put(key, kf.getOrDefault(key, 0) + 1);
        if (kf.get(key) > maxFreq) {
            maxFreq = kf.get(key);
        }
        ks.computeIfAbsent(kf.get(key), val -> new Stack<>()).push(key);
    }

    public int pop() {
        int res = ks.get(maxFreq).pop();
        kf.put(res, kf.get(res) - 1);
        if (ks.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// @lc code=end
