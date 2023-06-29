/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UF uf = new UF(n);
        List<List<String>> ans = new ArrayList<>();

        // remove duplicates and union those are the same
        HashMap<String, Integer> emailMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailMap.containsKey(email)) {
                    emailMap.put(email, i);
                } else {
                    uf.union(i, emailMap.get(email));
                }
            }

        // merge emails
        HashMap<Integer, List<String>> components = new HashMap<>();
        for (String email : emailMap.keySet()) {
            int idx = emailMap.get(email);
            int groupRepo = uf.find(idx);

            components.computeIfAbsent(groupRepo, val -> new ArrayList<>()).add(email);
        }

        // sort and generate ans

        for (int groupRepo : components.keySet()) {
            List<String> component = components.get(groupRepo);
            Collections.sort(component);
            component.add(0, accounts.get(groupRepo).get(0));
            ans.add(component);
        }
        return ans;

    }
}

class UF {
    int count;
    int[] parent;
    int[] size;

    UF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (size[x] < size[y]) {
                size[y] += size[x];
                parent[x] = y;
            } else {
                size[x] += size[y];
                parent[y] = x;
            }
        }
    }
}
// @lc code=end
