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
        temp = new Pair[nums.length];
        count = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        sort(arr, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int c : count) {
            ans.add(c);
        }
        return ans;
    }

    public void sort(Pair[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + (j - i) / 2;
        sort(nums, i, mid);
        sort(nums, mid + 1, j);
        merge(nums, i, mid, j);

    }

    public void merge(Pair[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == hi + 1) {
                nums[k] = temp[i++];
                count[nums[k].id] += j - mid - 1;
            } else if (temp[i].val <= temp[j].val) {
                nums[k] = temp[i++];
                count[nums[k].id] += j - mid - 1;
            } else {
                nums[k] = temp[j++];

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
