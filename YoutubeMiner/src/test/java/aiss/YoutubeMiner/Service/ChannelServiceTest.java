package aiss.YoutubeMiner.Service;

import aiss.YoutubeMiner.model.channel.Channel;
import aiss.YoutubeMiner.model.channel.ChannelSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChannelServiceTest {
    @Autowired
    ChannelService service;
    @Test
    @DisplayName("Get One channel")
    void getOneChannel() {
        ChannelSearch channel = service.findOne("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU" , "UCPGxA_W_5MF4U1r9CMt6htg");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(channel);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }

    @Test
    @DisplayName("Get All channels")
    void getAllChannels(){
        ChannelSearch channels = service.findAllChannels("AIzaSyD_sAw_5b53aSc8qx-G4sDCLhPOZ2H5JGU");
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
        System.out.println(channels);
        System.out.println("---------------------------------------------------------------" +
                "-------------------------------------------");
    }
}