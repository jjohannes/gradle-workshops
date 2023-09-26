package org.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessageServiceTest {

    @Test
    void test1() {
        assertNotNull(new MessageService());
        //assertEquals(0, 1);
    }
}
