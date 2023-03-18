/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    private int[] temp;

    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == hi + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] < temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }

}
// @lc code=end
