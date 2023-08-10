package org.example.logic;

import org.apache.commons.lang3.StringUtils;
import org.example.data.Message;
import org.slf4j.LoggerFactory;

public class MessageService extends Message {

    public Message doSmth() {
        StringUtils.capitalize("ss");
        LoggerFactory.getLogger(MessageService.class).info("running service");
        return new Message();
    }
}
