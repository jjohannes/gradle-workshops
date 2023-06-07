package org.example.logic;

import org.apache.commons.lang3.StringUtils;
import org.example.data.Message;
import org.slf4j.Logger;

public class MessageService extends StringUtils{

    public void use(Logger log) {
        String x = StringUtils.capitalize("abc");
        Message message = new Message();
        System.out.println(message + x);
    }
}
