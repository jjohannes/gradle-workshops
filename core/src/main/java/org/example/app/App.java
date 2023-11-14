package org.example.app;

import org.apache.commons.text.CaseUtils;

public class App {

    public static void main(String[] args) {
        System.out.println(CaseUtils.toCamelCase("Hello World", true));
    }
}
