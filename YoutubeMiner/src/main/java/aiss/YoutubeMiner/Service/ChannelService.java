package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.CaptionPost;
import aiss.YoutubeMiner.ModelPost.ChannelPost;
import aiss.YoutubeMiner.ModelPost.CommentPost;
import aiss.YoutubeMiner.ModelPost.VideoPost;
import aiss.YoutubeMiner.model.channel.Channel;
import aiss.YoutubeMiner.model.channel.ChannelSearch;
import aiss.YoutubeMiner.model.channel.ChannelSnippet;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippet;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetDetails;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetId;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VideoService videoService;

    public ChannelSearch findOne(String key, String id) {
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=" + key + "&part=snippet&id=" + id;
        ChannelSearch channelSearch = restTemplate.getForObject(uri, ChannelSearch.class);
        return channelSearch;
        }

    public ChannelSearch findAllChannels(String key){
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=" + key + "&part=snippet&forHandle=GoogleDevelopers";
        ChannelSearch channelSearch = restTemplate.getForObject(uri , ChannelSearch.class);
        return channelSearch;
    }

    public ChannelPost getChannel(String key, String id) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ChannelSearch> request = new HttpEntity<ChannelSearch>(headers);

        String uri = "https://www.googleapis.com/youtube/v3/channels?key=" + key + "&part=snippet&id=" + id;
        ResponseEntity<ChannelSearch> response = restTemplate.exchange(uri, HttpMethod.GET, request, ChannelSearch.class);
        ChannelSearch channelSearch = response.getBody();
        ChannelPost Channel = new ChannelPost(channelSearch.getItems().get(0).getId(),
                channelSearch.getItems().get(0).getSnippet().getTitle(), channelSearch.getItems().get(0).getSnippet().getDescription(),
                channelSearch.getItems().get(0).getSnippet().getPublishedAt());
        // Add Videos
        List<VideoSnippetSearch> videoSearch = videoService.getVideosFromChannel(key, id);
        List<VideoPost> videos = new ArrayList<>();

        for (VideoSnippetSearch videoSnippetSearch : videoSearch) {
            for (VideoSnippet videoSnippet : videoSnippetSearch.getItems()) {
                VideoSnippetDetails snippet = videoSnippet.getSnippet(); // Get the snippet details
                VideoSnippetId snippetId = videoSnippet.getId(); // Get the snippet id
                String videoId = snippetId.getVideoId(); // Get the video id from the snippet id
                String title = snippet.getTitle();
                String description = snippet.getDescription();
                String publishedAt = snippet.getPublishedAt();
                //List<CommentPost> comments = videoSnippet.getComments(); // Accessing comments directly
                //List<CaptionPost> captions = videoSnippet.getCaptions(); // Accessing captions directly

                // Create VideoPost object and add to videos list
                VideoPost newVideo = new VideoPost(snippetId, title, description, publishedAt);//, comments, captions);
                videos.add(newVideo);
            }
        }
        Channel.setVideos(videos);
        return Channel;
    }}