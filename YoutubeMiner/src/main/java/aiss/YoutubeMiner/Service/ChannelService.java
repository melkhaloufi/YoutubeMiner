package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.ChannelPost;
import aiss.YoutubeMiner.ModelPost.VideoPost;
import aiss.YoutubeMiner.model.channel.Channel;
import aiss.YoutubeMiner.model.channel.ChannelSearch;
import aiss.YoutubeMiner.model.channel.ChannelSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        String uri = "https://www.googleapis.com/youtube/v3/channels?key=" + key + "&id=" + id + "&part=snippet";
        ResponseEntity<ChannelSearch> response = restTemplate.getForEntity(uri, ChannelSearch.class);

        Channel channel = response.getBody().getItems().get(0);
        ChannelSnippet snippet = channel.getSnippet();
        List<VideoPost> videos = videoService.findVideosByChannelId(key, id);

        return new ChannelPost(
                channel.getId(),
                snippet.getTitle(),
                snippet.getDescription(),
                snippet.getPublishedAt(),
                videos
        );
    }

}