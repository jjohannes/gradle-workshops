package org.example.service;

import org.apache.commons.lang3.StringUtils;
import org.example.Message;
import org.slf4j.LoggerFactory;

public class MessageService {

    public void use(Message m) {
        StringUtils s;
        LoggerFactory.getLogger(MessageService.class).info("running");
    }

}
