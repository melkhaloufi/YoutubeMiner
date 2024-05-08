package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.CaptionPost;
import aiss.YoutubeMiner.model.caption.CaptionSearch;
import aiss.YoutubeMiner.model.comment.CommentSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CaptionServiceTest {

    @Autowired
    CaptionService service;

    @Test
    @DisplayName("Get Captions From A Video")
    void getCaptionsFromVideo() {
        List<CaptionSearch> captions = service.getCaptionsFromVideo("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU", "IYDVcriKjsw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(captions);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");


    }

    @Test
    @DisplayName("Get Captions From A Video2")
    void getCaptions() {
        List<CaptionPost> captions = service.findCaptionsByVideoId("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU", "IYDVcriKjsw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(captions);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }
}