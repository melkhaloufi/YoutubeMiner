package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.channel.ChannelSearch;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippet;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class VideoService {
    @Autowired
    RestTemplate restTemplate;
    public VideoSnippetSearch getAllchannels(String key) {
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + key + "&part=snippet&type=video";
        VideoSnippetSearch videoSnippet = restTemplate.getForObject(uri, VideoSnippetSearch.class);
        return videoSnippet;
    }

}
