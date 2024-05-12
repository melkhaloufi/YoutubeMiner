package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.CaptionPost;
import aiss.YoutubeMiner.ModelPost.CommentPost;
import aiss.YoutubeMiner.ModelPost.VideoPost;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippet;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentService commentService;

    @Autowired
    CaptionService captionService;


    public VideoSnippetSearch getAllVideos(String key) {
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + key + "&part=snippet&type=video";
        VideoSnippetSearch videoSnippet = restTemplate.getForObject(uri, VideoSnippetSearch.class);
        return videoSnippet;
    }

    public List<VideoSnippetSearch> getVideosFromChannel(String key , String id) {
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + key + "&channelId=" + id + "&part=snippet&type=video";
        VideoSnippetSearch videoSnippet = restTemplate.getForObject(uri, VideoSnippetSearch.class);
        List<VideoSnippetSearch> videoSnippetList = new ArrayList<>();
        videoSnippetList.add(videoSnippet);
        return videoSnippetList;
    }

    public List<VideoPost> findVideosByChannelId(String key, String id) {
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + key + "&channelId=" + id + "&part=snippet&type=video";
        ResponseEntity<VideoSnippetSearch> response = restTemplate.getForEntity(uri, VideoSnippetSearch.class);

        List<VideoSnippet> items = response.getBody().getItems();
        List<VideoPost> videos = new ArrayList<>();
        for (VideoSnippet video : items) {
            String videoId = video.getId().getVideoId(); // Assuming getVideoId() returns the video ID as a string
            List<CommentPost> comments = commentService.findCommentsByVideoId(key, videoId);
            List<CaptionPost> captions = captionService.findCaptionsByVideoId(key, videoId);

            VideoPost result = new VideoPost(
                    video.getId().getVideoId(),
                    video.getSnippet().getTitle(),
                    video.getSnippet().getDescription(),
                    video.getSnippet().getPublishedAt(),
                    comments,
                    captions
            );
            videos.add(result);
        }
        return videos;
    }

}
