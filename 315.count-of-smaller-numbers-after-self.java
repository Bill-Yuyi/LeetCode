import java.util.*;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    Pair[] temp;
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        temp = new Pair[n];
        count = new int[n];
        Pair[] map = new Pair[n];
        for (int i = 0; i < n; i++) {
            map[i] = new Pair(nums[i], i);
        }
        sort(map, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int c : count) {
            ans.add(c);
        }
        return ans;
    }

    void sort(Pair[] map, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        sort(map, left, mid);
        sort(map, mid + 1, right);
        merge(map, left, mid, right);
    }

    void merge(Pair[] map, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = map[i];
        }

        int i = left, j = mid + 1;
        while (i <= mid || j <= right) {
            if (i <= mid && j <= right) {
                if (temp[i].val <= temp[j].val) {
                    map[left++] = temp[i];
                    count[temp[i].id] += j - mid - 1;
                    i++;
                } else {
                    map[left++] = temp[j++];
                }
            } else {
                if (i <= mid) {
                    map[left++] = temp[i];
                    count[temp[i].id] += j - mid - 1;
                    i++;
                } else {
                    map[left++] = temp[j++];
                }
            }
        }
    }

}

class Pair {
    int val, id;

    Pair(int val, int id) {
        this.val = val;
        this.id = id;
    }
}
// @lc code=end
