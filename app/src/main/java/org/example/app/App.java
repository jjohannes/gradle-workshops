package org.example.app;

import org.example.Message;
import org.example.service.MessageService;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello!");
        new Message();
        // new MessageService().use(new Message());
    }
}
