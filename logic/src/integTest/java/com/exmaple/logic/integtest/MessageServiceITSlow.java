package com.exmaple.logic.integtest;

import com.example.logic.MessageService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("slow")
public class MessageServiceITSlow {

    @Test
    void intTest() throws InterruptedException {
        Thread.sleep(15000);
        new MessageService();
    }
}
