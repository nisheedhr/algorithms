package com.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

    Map<Integer, Set<Integer>> userFollowees = new HashMap<>();
    Map<Integer, List<Tweet>> userTweets = new HashMap<>();
    
    int tweetSeq = 0;
    
    private  class Tweet {
        int id;
        int seq;
        
        Tweet(int id) {
            this.id = id;
            this.seq = tweetSeq++;
        }
    };
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }
        userTweets.get(userId).add(new Tweet(tweetId));
        
        if (userTweets.get(userId).size() > 10) {
            userTweets.get(userId).remove(0);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must 
     * be posted by users who the user followed or by the user herself. 
     * Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweets = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.seq - a.seq);
        if (userTweets.containsKey(userId)) {
            pq.addAll(userTweets.get(userId));
        }

        if (userFollowees.containsKey(userId)) {
            for (Integer user : userFollowees.get(userId)) {
                if (userTweets.containsKey(user)) {
                    pq.addAll(userTweets.get(user));
                }
            }
        }

        while (!pq.isEmpty() && tweets.size() < 10) {
            tweets.add(pq.poll().id);
        }
        return tweets;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        
        if (!userFollowees.containsKey(followerId)) {
            Set<Integer> followees = new HashSet<>();
            userFollowees.put(followerId, followees);
        }
        userFollowees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userFollowees.containsKey(followerId)) {
            userFollowees.get(followerId).remove(followeeId);
        }
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
