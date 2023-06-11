/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */

// @lc code=start

import java.util.HashMap;

class SnapshotArray {

    int snapTimes = 0;
    TreeMap<Integer, Integer>[] records;

    public SnapshotArray(int length) {
        records = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            records[i] = new TreeMap<Integer, Integer>();
            records[i].put(0, 0);
        }

    }

    public void set(int index, int val) {
        records[index].put(snapTimes, val);
    }

    public int snap() {
        return snapTimes++;
    }

    public int get(int index, int snap_id) {
        return records[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end
