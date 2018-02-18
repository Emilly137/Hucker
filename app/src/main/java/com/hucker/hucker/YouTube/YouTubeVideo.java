package com.hucker.hucker.YouTube;

public class YouTubeVideo {
    private String videoUrl;

    public YouTubeVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public YouTubeVideo() {
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
