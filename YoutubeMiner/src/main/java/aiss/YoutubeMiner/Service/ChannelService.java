package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.channel.ChannelSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    public ChannelSearch findAllChannels(String key) {
        String uri = "https://www.googleapis.com/youtube/v3/search?key=" + key + "&part=snippet&type=channel";
        return restTemplate.getForObject(uri, ChannelSearch.class);

    }
}
