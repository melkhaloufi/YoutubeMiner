package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.caption.CaptionSearch;
import aiss.YoutubeMiner.model.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;
    public List<CaptionSearch> getCaptionsFromVideo(String key , String id) {
        String uri = "https://www.googleapis.com/youtube/v3/captions?key=" + key + "&part=snippet&videoId="+id;
        CaptionSearch captionSearch = restTemplate.getForObject(uri, CaptionSearch.class);
        List<CaptionSearch> captionSearchList = new ArrayList<>();
        captionSearchList.add(captionSearch);
        return captionSearchList;
    }

}
