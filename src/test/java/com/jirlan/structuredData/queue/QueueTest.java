package com.jirlan.structuredData.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QueueTest {
    @Test
    public void shouldCreateEmptyQueue() {
        var queue = new Queue<Integer>();
        assertNotNull(queue);
        assertNotNull(queue.linkedList);
    }

    @Test
    public void shouldEnqueueDataToQueue() {
        var queue = new Queue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.toString()," 1, 2,");
    }
}
