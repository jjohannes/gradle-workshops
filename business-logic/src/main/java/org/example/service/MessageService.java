package org.example.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.example.data.Message;
import org.slf4j.LoggerFactory;

public class MessageService {

    private CaseUtils utils;

    public void doSomething(Message m) {
        StringUtils u;
        LoggerFactory.getLogger(MessageService.class).info("hey");
    }
}
