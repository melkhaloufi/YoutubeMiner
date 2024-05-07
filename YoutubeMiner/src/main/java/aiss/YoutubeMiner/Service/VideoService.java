package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.OneVideo.OneVideoSearch;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    RestTemplate restTemplate;
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

    public OneVideoSearch getOneVideo (String key , String  id){
        String uri = "https://www.googleapis.com/youtube/v3/videos?key=" + key + "&part=snippet&id=" + id;
        OneVideoSearch oneVideo = restTemplate.getForObject(uri , OneVideoSearch.class);
        return oneVideo;
    }



}
