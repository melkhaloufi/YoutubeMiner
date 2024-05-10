package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.CommentPost;
import aiss.YoutubeMiner.model.comment.CommentSearch;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;
    @Test
    @DisplayName("Get Comments From A Video")
    void getCommentFromVideo() {
        List<CommentSearch> comments = service.getCommentsFromVideo("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU","IYDVcriKjsw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(comments);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }

    @Test
    @DisplayName("Get Comments From A Video2")
    void getComment() {
        List<CommentPost> comments = service.findCommentsByVideoId("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU","FlXWmIcUqBw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(comments);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
}
}