package com.example.app;

import com.example.data.Message;
import com.example.logic.MessageService;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello!");
        new MessageService().useService(new Message(":)"));
    }
}
