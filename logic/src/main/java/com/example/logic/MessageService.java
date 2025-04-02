package com.example.logic;

import com.example.data.Message;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    public void useService(Message m) {
        StringEscapeUtils.escapeJava("abc");
        m.print();
        LOGGER.info("Printed Message");
    }
}
