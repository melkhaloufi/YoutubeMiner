package aiss.YoutubeMiner.Controller;

import aiss.YoutubeMiner.ModelPost.ChannelPost;
import aiss.YoutubeMiner.Service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
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

        String uri = "http://localhost:8080/VideoMiner/channels";
        return template.postForObject(uri, channel, ChannelPost.class);
    }
    @GetMapping("/{key}/{id}")
    public ChannelPost getChannel(@PathVariable String key,
                              @PathVariable String id,
                              @RequestParam(defaultValue = "10") Integer maxVideos,
                              @RequestHeader(defaultValue = "10") Integer maxComments) {

        ChannelPost channel = channelService.getChannel(key, id);
        return channel;
    }
}
