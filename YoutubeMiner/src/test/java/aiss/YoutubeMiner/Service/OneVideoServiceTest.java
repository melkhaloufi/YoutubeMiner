package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.OneVideo.OneVideoSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneVideoServiceTest {
    @Autowired
    VideoService service;

    @Test
    @DisplayName("Get One Video")
    void getOneVideo() {
        OneVideoSearch video = service.getOneVideo("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU","IYDVcriKjsw");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(video);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }
}
