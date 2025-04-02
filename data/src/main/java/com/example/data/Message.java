package com.example.data;

import org.apache.commons.lang3.StringUtils;

public class Message {
    private final String m;

    public Message(String m) {
        this.m = m;
    }

    public void print() {
        System.out.println(m + StringUtils.EMPTY);
    }
}
