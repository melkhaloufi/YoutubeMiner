package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.caption.CaptionSearch;
import aiss.YoutubeMiner.model.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;
    public CaptionSearch getCaptionsFromVideo(String key , String id) {
        String uri = "https://www.googleapis.com/youtube/v3/captions?key=" + key + "&part=snippet&videoId="+id;
        CaptionSearch captionSearch = restTemplate.getForObject(uri, CaptionSearch.class);
        return captionSearch;
    }

}
