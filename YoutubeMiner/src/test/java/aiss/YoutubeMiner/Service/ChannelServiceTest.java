package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.channel.ChannelSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChannelServiceTest {
    @Autowired
    ChannelService service;
    @Test
    @DisplayName("Get All channels")
    void getChannel() {
        ChannelSearch canal= service.findAllChannels("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU");
        System.out.println(canal);
    }
}