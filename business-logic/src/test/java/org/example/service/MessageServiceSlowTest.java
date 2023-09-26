package org.example.service;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("slow")
class MessageServiceSlowTest {

    @Test
    void test1() {
        assertNotNull(new MessageService());
        //assertEquals(0, 1);
    }
}
