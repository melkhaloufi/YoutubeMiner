package aiss.YoutubeMiner.Controller;

import aiss.YoutubeMiner.ModelPost.ChannelPost;
import aiss.YoutubeMiner.ModelPost.CommentPost;
import aiss.YoutubeMiner.ModelPost.VideoPost;
import aiss.YoutubeMiner.Service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/YoutubeMiner")
public class ChannelController {
    @Autowired
    RestTemplate template;

    @Autowired
    ChannelService channelService;

    //POST http://localhost:8082/YoutubeMiner/{key}/{id}[?maxVideos=10&maxComments=10]
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{key}/{id}")
    public ChannelPost create(@PathVariable String key,
                          @PathVariable String id,
                          @RequestParam(defaultValue = "10") Integer maxVideos,
                          @RequestHeader(defaultValue = "10") Integer maxComments) {

        ChannelPost channel = channelService.getChannel(key, id);
        List<VideoPost> videos = channel.getVideos();
        Integer _maxComments = videos.size()<maxVideos?maxComments/videos.size():maxComments/maxVideos;
        if (maxVideos >= 0 && videos.size() > maxVideos) {
            channel.setVideos(videos.subList(0, maxVideos));
        }
        for (VideoPost video : channel.getVideos()) {
            List<CommentPost> comments = video.getComments();
            if (_maxComments >= 0 && comments.size() > _maxComments) {
                List<CommentPost> truncatedComments = new ArrayList<>(comments.subList(0, _maxComments));
                video.setComments(truncatedComments);
            }
        }

        String uri = "http://localhost:8080/VideoMiner/channels";
        return template.postForObject(uri, channel, ChannelPost.class);
    }
    //GET http://localhost:8082/YoutubeMiner/{key}/{id}[?maxVideos=10&maxComments=10]
    @GetMapping("/{key}/{id}")
    public ChannelPost getChannel(@PathVariable String key,
                              @PathVariable String id,
                              @RequestParam(defaultValue = "10") Integer maxVideos,
                              @RequestHeader(defaultValue = "10") Integer maxComments) {

        ChannelPost channel = channelService.getChannel(key, id);

        List<VideoPost> videos = channel.getVideos();
        if (maxVideos >= 0 && videos.size() > maxVideos) {
            channel.setVideos(videos.subList(0, maxVideos));
        }
        for (VideoPost video : channel.getVideos()) {
            List<CommentPost> comments = video.getComments();
            if (maxComments >= 0 && comments.size() > maxComments) {
                video.setComments(comments.subList(0, maxComments));
            }
        }
        return channel;
    }
}
