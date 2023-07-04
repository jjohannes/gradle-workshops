package org.example.app;

import org.example.data.Message2;
import org.example.logic.MessageService;

public class App {

    public static void main(String[] args) {
        new MessageService().print(new Message2());
    }
}
