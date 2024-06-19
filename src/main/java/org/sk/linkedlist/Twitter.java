package org.sk.linkedlist;

import java.util.*;

public class Twitter {

    private final LinkedList<int[]> tweetsMap;
    private final HashMap<Integer, Set<Integer>> userFollowerMap;
    private final int maxNewsFeed = 10;

    public Twitter() {
        tweetsMap = new LinkedList<>();
        userFollowerMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetsMap.push(new int[]{tweetId, userId});
        userFollowerMap.computeIfAbsent(userId, v -> new HashSet<>()).add(userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = userFollowerMap.get(userId);
        List<Integer> newsFeed = new ArrayList<>();
        if (Objects.nonNull(followers) && !followers.isEmpty()) {
            for (int[] tweet : tweetsMap) {
                if (newsFeed.size() < maxNewsFeed) {
                    if (followers.contains(tweet[1])) newsFeed.add(tweet[0]);
                } else {
                    break;
                }
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        userFollowerMap.computeIfAbsent(followerId, v -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userFollowerMap.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));

        t = new Twitter();
        t.postTweet(1, 1);
        System.out.println(t.getNewsFeed(1));
        t.follow(2, 1);
        System.out.println(t.getNewsFeed(2));
        t.unfollow(2, 1);
        System.out.println(t.getNewsFeed(2));
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
