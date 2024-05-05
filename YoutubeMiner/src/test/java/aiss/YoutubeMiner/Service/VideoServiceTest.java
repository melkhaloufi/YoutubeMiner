package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.channel.ChannelSearch;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippet;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;
    @Test
    @DisplayName("Get All channel")
    void getAllChannel() {
        VideoSnippetSearch videos = service.getAllchannels("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(videos);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }

    @Test
    @DisplayName("Get All channel")
    void getOne() {
        VideoSnippetSearch video = service.getOne("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU","UCPGxA_W_5MF4U1r9CMt6htg");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(video);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }
}