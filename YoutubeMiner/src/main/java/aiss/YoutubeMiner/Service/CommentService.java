package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.comment.CommentSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;
    public List<CommentSearch> getCommentsFromVideo(String key , String id) {
        String uri = "https://www.googleapis.com/youtube/v3/commentThreads?key=" + key + "&part=snippet&videoId="+id;
        CommentSearch commentSearch = restTemplate.getForObject(uri, CommentSearch.class);
        List<CommentSearch> commentSearchList = new ArrayList<>();
        commentSearchList.add(commentSearch);
        return commentSearchList;
    }
}
