

package org.example.app;

import org.example.logic.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App extends MessageService{

    public static void main(String[] args) {
        System.out.println("Hello");
        Logger l = LoggerFactory.getLogger(App.class);
        new MessageService().use(l);
    }
}
