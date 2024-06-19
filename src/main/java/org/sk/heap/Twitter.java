package org.sk.heap;

import java.util.*;

class Twitter {

    private final Map<Integer, Set<Integer>> userFollowerMap;
    private final Map<Integer, List<int[]>> userTweetsMap;
    private int timestamp;
    private final int maxNewsFeed = 10;

    public Twitter() {
        userFollowerMap = new HashMap<>();
        userTweetsMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweetsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{tweetId, timestamp++});
        userFollowerMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followers = userFollowerMap.get(userId);
        if (followers == null) {
            return Collections.emptyList();
        }
        TreeSet<int[]> mostRecentTweets = new TreeSet<>((t1, t2) -> Integer.compare(t2[1], t1[1]));
        for (int followerId : followers) {
            List<int[]> tweets = userTweetsMap.get(followerId);
            if (tweets != null) {
                for (int[] tweet : tweets) {
                    mostRecentTweets.add(tweet);
                    if (mostRecentTweets.size() > maxNewsFeed) {
                        mostRecentTweets.pollLast();
                    }
                }
            }
        }

        List<Integer> newsFeed = new ArrayList<>(mostRecentTweets.size());
        for (int[] tweet : mostRecentTweets) {
            newsFeed.add(tweet[0]);
        }
        mostRecentTweets.clear();
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        userFollowerMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
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
