package com.exmaple.logic.integtest;

import com.example.logic.MessageService;
import org.junit.jupiter.api.Test;

public class MessageServiceIT {

    @Test
    void intTest() throws InterruptedException {
        Thread.sleep(5000);
        new MessageService();
    }
}
