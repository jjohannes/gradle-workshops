package org.example.app;

import org.example.data.Message;
import org.example.logic.MessageService;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello");
        new MessageService().doSmth();
        new Message();
    }
}
