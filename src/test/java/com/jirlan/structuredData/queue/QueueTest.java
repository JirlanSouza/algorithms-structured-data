package com.jirlan.structuredData.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void shouldCreateEmptyQueue() {
        var queue = new Queue<Integer>(Integer.class, 20);
        assertNull(queue.peek());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldEnqueueDataToQueue() {
        var queue = new Queue<Integer>(Integer.class, 20);

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.toString(), " 1, 2,");
    }

    @Test
    public void shouldBePossibleToEnqueueAndDequeueData() {
        var queue = new Queue<Integer>(Integer.class, 20);

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.toString(), " 1, 2,");
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
    }

    @Test
    public void shouldPeekDataFromQueue() {
        var queue = new Queue<Integer>(Integer.class, 20);

        assertNull(queue.peek());

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.peek(), 1);
        assertEquals(queue.peek(), 1);
    }

    @Test
    public void shouldCheckIfQueueIsEmpty() {
        var queue = new Queue<Integer>(Integer.class, 20);

        assertTrue(queue.isEmpty());

        queue.enqueue(1);

        assertFalse(queue.isEmpty());
    }

    @Test
    public void shouldDequeueFromQueueInFIFOOrder() {
        var queue = new Queue<Integer>(Integer.class, 20);

        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.dequeue(), 2);
        assertNull(queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldQueueAndDequeueManyData() {
        var queue = new Queue<Integer>(Integer.class, 20);

        for (int i = 0; i < 30; i++) {
            queue.enqueue(1 + i);
            queue.enqueue(2 + i);
            assertEquals(queue.dequeue(), 1 + i);
            assertEquals(queue.dequeue(), 2 + i);
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    public void shouldNotQueueDataOverQueueCapacity() {
        var queue = new Queue<Integer>(Integer.class, 20);

        assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < 30; i++) {
                queue.enqueue(1 + i);
            }
        });
    }
}
