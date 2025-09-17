package leetcode_problems.medium;

import java.util.*;

public class DesignTwitter_355 {

    // Approach 1: Feed-pul model

    private record Post(int posterId, int tweetId, int time) {
    }

    private int time;
    private final Map<Integer, Set<Integer>> followees;
    private final Map<Integer, List<Post>> posts;  // posterId -> set of their posts

    public DesignTwitter_355() {
        this.time = 0;
        this.followees = new HashMap<>();
        this.posts = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(userId,
                k -> new ArrayList<>()).add(new Post(userId, tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> users = followees.getOrDefault(userId, new HashSet<>());
        users.add(userId);

        // {time, userId, tweetId, idx}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int u : users) {
            List<Post> userPosts = posts.get(u);
            if (userPosts != null && !userPosts.isEmpty()) {
                int n = userPosts.size();
                Post lastPost = userPosts.get(n - 1);
                pq.offer(new int[]{lastPost.time, lastPost.posterId, lastPost.tweetId, n - 1});
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty() && result.size() < 10) {
            int[] latestPost = pq.poll();
            int id = latestPost[1];
            int tweetId = latestPost[2];
            int idx = latestPost[3];

            result.add(tweetId);
            if (idx > 0) {
                Post prev = posts.get(id).get(idx - 1);
                pq.offer(new int[]{prev.time, prev.posterId, prev.tweetId, idx - 1});
            }
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
    }

    /*
            Approach 2: Feed-push model

    private record Post(int posterId, int tweetId, int time) {}
    // comparator: newest time first
    private static final Comparator<Post> TIME_DESC =
            (a, b) -> Integer.compare(b.time(), a.time());

    private int time;
    // followeeId -> set of followerIds
    private final Map<Integer, Set<Integer>> followers;
    private final Map<Integer, Set<Post>> posts;           // posterId -> set of their posts
    private final Map<Integer, PriorityQueue<Post>> feeds; // userId -> pq of posts for their feed

    public DesignTwitter_355() {
        this.time = 0;
        this.followers = new HashMap<>();
        this.posts = new HashMap<>();
        this.feeds = new HashMap<>();
    }

    // push new post into poster's feed and into every follower's feed
    public void postTweet(int userId, int tweetId) {
        Post newPost = new Post(userId, tweetId, time);

        // store in poster's posts set
        posts.computeIfAbsent(userId, k -> new HashSet<>()).add(newPost);

        // add to poster's feed
        feeds.computeIfAbsent(userId, k -> new PriorityQueue<>(TIME_DESC)).offer(newPost);

        // push to each follower's feed (followee -> followers mapping)
        // use Collections.emptySet() if no followers (safe, no mutation)
        for (int followerId : followers.getOrDefault(userId, new HashSet<>())) {
            feeds.computeIfAbsent(followerId, k -> new PriorityQueue<>(TIME_DESC)).offer(newPost);
        }

        time++;
    }

    // return up to 10 most recent tweetIds from the user's feed
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Post> userFeed = feeds.computeIfAbsent(userId, k -> new PriorityQueue<>(TIME_DESC));

        List<Post> recent = new ArrayList<>(10);
        while (recent.size() < 10 && !userFeed.isEmpty()) {
            recent.add(userFeed.poll());
        }

        // restore
        userFeed.addAll(recent);
        return recent.stream().map(Post::tweetId).collect(Collectors.toList());
    }

    // add followerId into followee's follower set
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        Set<Integer> fs = followers.computeIfAbsent(followeeId, k -> new HashSet<>());
        if(fs.contains(followerId)) return;

        fs.add(followerId);
        // add all existing posts of followee into follower's feed
        Set<Post> followeePosts = posts.getOrDefault(followeeId, Collections.emptySet());
        PriorityQueue<Post> followerFeed = feeds.computeIfAbsent(followerId, k -> new PriorityQueue<>(TIME_DESC));
        followerFeed.addAll(followeePosts);
    }

    // remove followerId from followee's follower set and remove followee posts from follower's feed
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fs = followers.getOrDefault(followeeId, new HashSet<>());
        fs.remove(followerId);
        if (fs.isEmpty()) followers.remove(followeeId);

        PriorityQueue<Post> followerFeed = feeds.get(followerId);
        if (followerFeed == null || followerFeed.isEmpty()) return;

        List<Post> retained = new ArrayList<>();
        while (!followerFeed.isEmpty()) {
            Post p = followerFeed.poll();
            if (p.posterId() != followeeId) retained.add(p);
        }
        followerFeed.addAll(retained);
    }
     */
}
