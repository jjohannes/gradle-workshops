package org.example.app;

import org.apache.commons.lang3.StringUtils;
import org.example.service.MessageService;
// import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) {
        StringUtils.capitalize("!!!");
        // System.out.println("Hello!");
        // LoggerFactory.getLogger(App.class).info("Hello!");
        new MessageService();
    }
}
