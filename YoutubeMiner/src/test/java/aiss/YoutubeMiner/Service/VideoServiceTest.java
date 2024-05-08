package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.ModelPost.VideoPost;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;

    @Test
    @DisplayName("Get All Videos")
    void getAllVideos() {
        VideoSnippetSearch videos = service.getAllVideos("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(videos);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }

    @Test
    @DisplayName("Get Videos From Channel")
    void getVideosFromChannel() {
        List<VideoSnippetSearch> video = service.getVideosFromChannel("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU","UCTdY7Fw0YMHCJ09jKTGy9Xw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(video);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }

    @Test
    @DisplayName("Get Videos by channel Id")
    void getOneVideo() {
        List<VideoPost> video = service.findVideosByChannelId("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU","UCTdY7Fw0YMHCJ09jKTGy9Xw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(video);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }

}