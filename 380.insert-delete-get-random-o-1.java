import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new LinkedList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int lastElement = list.get(list.size() - 1);
        map.put(lastElement, idx);
        list.set(idx, lastElement);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
// @lc code=end
