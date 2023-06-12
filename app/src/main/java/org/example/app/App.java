package org.example.app;

import org.example.data.Message;
import org.example.logic.MessageService;
import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) {
        Message m = new Message();
        LoggerFactory.getLogger(App.class).info("Hi!");

        new MessageService().doWork(m);
        System.out.println("Hello! :)");
    }
}
