package org.example.app;

import org.example.data.Message;
import org.example.service.MessageService;

public class App {

    public static void main(String[] args) {
        new MessageService().doSomething(new Message());
        System.out.println("Hello!!");
    }
}
