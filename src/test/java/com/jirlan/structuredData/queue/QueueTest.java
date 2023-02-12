package com.jirlan.structuredData.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldBePossibleToEnqueueAndDequeueData() {
        var queue = new Queue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.toString(), " 1, 2,");
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
    }

    @Test
    public void shouldPeekDataFromQueue() {
        var queue = new Queue<Integer>();

        assertNull(queue.peek());

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.peek(), 1);
        assertEquals(queue.peek(), 1);
    }

    @Test
    public void shouldCheckIfQueueIsEmpty() {
        var queue = new Queue<Integer>();

        assertTrue(queue.isEmpty());

        queue.enqueue(1);

        assertFalse(queue.isEmpty());
    }
    
    @Test
    public void shouldDequeueFromQueueInFIFOOrder() {
        var queue = new Queue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertNull(queue.dequeue());
        System.out.println(queue);
        assertTrue(queue.isEmpty());
    }
}
