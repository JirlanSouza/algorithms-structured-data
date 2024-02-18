package com.jirlan.structuredData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PriorityQueueTest {
    @Test
    public void shouldDequeueItemsWithPriority() {
        var priorityQueue = new PriorityQueue<Integer>(10, Integer.class);

        priorityQueue.insert(20);
        priorityQueue.insert(5);
        priorityQueue.insert(59);
        priorityQueue.insert(58);
        priorityQueue.insert(0);

        assertEquals(priorityQueue.dequeue(), 59);
        assertEquals(priorityQueue.dequeue(), 58);
        assertEquals(priorityQueue.dequeue(), 20);
        assertEquals(priorityQueue.dequeue(), 5);
        assertEquals(priorityQueue.dequeue(), 0);
        assertNull(priorityQueue.dequeue());
    }
}