package org.example.logic;

import org.example.data.Message2;
import org.slf4j.LoggerFactory;

public class MessageService {

    public void print(Message2 m) {
        LoggerFactory.getLogger(MessageService.class).info(Message2.MESSAGE);
    }
}
