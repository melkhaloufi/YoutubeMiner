package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.CommentPost;
import aiss.YoutubeMiner.ModelPost.UserPost;
import aiss.YoutubeMiner.model.comment.Comment;
import aiss.YoutubeMiner.model.comment.CommentSearch;
import aiss.YoutubeMiner.model.comment.CommentSnippet__1;
import aiss.YoutubeMiner.model.comment.TopLevelComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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

    public List<CommentPost> findCommentsByVideoId(String key, String id) {
        String uri = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=" + id + "&key=" + key;
        try {
            ResponseEntity<CommentSearch> response = restTemplate.getForEntity(uri, CommentSearch.class);
            List<Comment> items = response.getBody().getItems();
            List<CommentPost> comments = new ArrayList<>();

            for (int i = 0; i < items.size(); i++) {
                TopLevelComment comment = items.get(i).getCommentSnippet().getTopLevelComment();
                CommentSnippet__1 snippet = comment.getSnippet();

                UserPost user = new UserPost();
                user.setUser_link(snippet.getAuthorChannelUrl());
                user.setName(snippet.getAuthorDisplayName());
                user.setPicture_link(snippet.getAuthorProfileImageUrl());
                CommentPost result = new CommentPost();
                result.setId(comment.getId());
                result.setText(snippet.getTextOriginal());
                result.setCreatedOn(snippet.getPublishedAt());
                result.setAuthor(user);

                comments.add(result);
            }
            return comments;
        } catch (HttpClientErrorException.Forbidden e) {
            System.out.println("Comments are disabled for this video.");
            return new ArrayList<>();
        }
    }
}
