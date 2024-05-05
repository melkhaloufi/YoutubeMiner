package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.channel.Channel;
import aiss.YoutubeMiner.model.channel.ChannelSearch;
import aiss.YoutubeMiner.model.channel.ChannelSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
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
}
