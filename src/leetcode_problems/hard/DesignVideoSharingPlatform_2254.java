package leetcode_problems.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignVideoSharingPlatform_2254 {

    private record Video(String video, int likes, int dislikes, int views){}

    private int currIdx;
    private final Map<Integer, Video> videos;
    private final PriorityQueue<Integer> availableIdx;

    public DesignVideoSharingPlatform_2254() {
        this.currIdx = 0;
        this.videos = new HashMap<>();
        this.availableIdx = new PriorityQueue<>((a, b) -> a - b);
    }

    // Map<videoId(int), int[like, dislike, views]>
    public int upload(String video) {
        int idx = currIdx;
        if(!availableIdx.isEmpty()) idx = availableIdx.poll();

        videos.put(idx, new Video(video, 0, 0, 0));
        if(idx == currIdx) currIdx++;
        return idx;
    }

    public void remove(int videoId) {
        if(!videos.containsKey(videoId)) return;

        videos.remove(videoId);
        availableIdx.offer(videoId);
    }

    public String watch(int videoId, int startMinute, int endMinute) {
        if(!videos.containsKey(videoId)) return "-1";

        Video v = videos.get(videoId);
        videos.put(videoId, new Video(v.video, v.likes, v.dislikes, v.views + 1));
        return v.video.substring(startMinute, Math.min(endMinute + 1, v.video.length()));
    }

    public void like(int videoId) {
        videos.computeIfPresent(videoId,
                (k, v) -> new Video(v.video, v.likes + 1, v.dislikes, v.views));
    }

    public void dislike(int videoId) {
        videos.computeIfPresent(videoId,
                (k, v) -> new Video(v.video, v.likes, v.dislikes + 1, v.views));
    }

    public int[] getLikesAndDislikes(int videoId) {
        if(!videos.containsKey(videoId)) return new int[]{-1};

        Video v = videos.get(videoId);
        videos.put(videoId, new Video(v.video, v.likes, v.dislikes, v.views));
        return new int[]{v.likes, v.dislikes};
    }

    public int getViews(int videoId) {
        if(!videos.containsKey(videoId)) return -1;

        Video v = videos.get(videoId);
        return v.views;
    }
}
