package com.jirlan.structuredData.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QueueTest {
    @Test
    public void shouldCreateEmptyQueue() {
        var queue = new Queue();
        assertNotNull(queue);
        assertNotNull(queue.linkedList);
    };
}
