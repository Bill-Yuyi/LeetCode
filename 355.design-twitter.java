/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
import java.util.*;

class Twitter {
    HashMap<Integer, User> map;
    int time = 0;

    public Twitter() {
        map = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            User user = new User(userId);
            map.put(userId, user);
        }
        map.get(userId).addTweet(tweetId, time);

        time++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        if (!map.containsKey(userId)) {
            return ans;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.time - a.time));
        User user = map.get(userId);

        for (int f : user.followeeCollection) {
            if (map.get(f).tweetHead != null) {
                pq.offer(map.get(f).tweetHead);
            }
        }

        int n = 0;
        while (!pq.isEmpty() && n < 10) {
            Tweet t = pq.poll();
            ans.add(t.tweetId);
            n++;
            t = t.next;
            if (t != null) {
                pq.offer(t);
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followeeId)) {
            User user = new User(followeeId);
            map.put(followeeId, user);
        }
        if (!map.containsKey(followerId)) {
            User user = new User(followerId);
            map.put(followerId, user);
        }
        map.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!map.containsKey(followerId) || followeeId == followerId) {
            return;
        }
        map.get(followerId).unfollow(followeeId);
    }
}

class User {
    int id;
    Tweet tweetHead;
    Set<Integer> followeeCollection;

    User(int id) {
        this.id = id;
        this.tweetHead = null;
        followeeCollection = new HashSet<>();
        follow(id);
    }

    void follow(int userId) {
        followeeCollection.add(userId);
    }

    void unfollow(int userId) {
        if (followeeCollection.contains(userId)) {
            followeeCollection.remove(userId);
        }

    }

    void addTweet(int tweetId, int time) {
        if (tweetHead == null) {
            tweetHead = new Tweet(tweetId, time);
        } else {
            Tweet newTweet = new Tweet(tweetId, time);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

}

class Tweet {
    int tweetId;
    Tweet next;
    int time;

    Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end
