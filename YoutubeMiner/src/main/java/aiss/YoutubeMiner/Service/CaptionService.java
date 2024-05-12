package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.CaptionPost;
import aiss.YoutubeMiner.model.caption.Caption;
import aiss.YoutubeMiner.model.caption.CaptionSearch;
import aiss.YoutubeMiner.model.caption.CaptionSnippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public List<CaptionPost> findCaptionsByVideoId(String key, String id) {
        String uri = "https://www.googleapis.com/youtube/v3/captions?part=snippet&videoId=" + id + "&key=" + key;
        ResponseEntity<CaptionSearch> response = restTemplate.getForEntity(uri, CaptionSearch.class);

        List<Caption> items = response.getBody().getItems();
        List<CaptionPost> captions = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            Caption caption = items.get(i);
            CaptionSnippet snippet = caption.getSnippet();

            CaptionPost result = new CaptionPost();
            result.setId(caption.getId());
            result.setName(snippet.getName());
            result.setLanguage(snippet.getLanguage());

            captions.add(result);
        }
        return captions;
    }

}
