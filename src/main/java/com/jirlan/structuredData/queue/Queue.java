package com.jirlan.structuredData.queue;

import java.lang.reflect.Array;

public class Queue<T> {
    private int head;
    private int tail;
    private T[] data;

    public Queue() {
        this((Class<T>) Object.class, 16);
    }

    public Queue(Class<T> type, int capacity) {
        data = (T[]) Array.newInstance(type, capacity);
    }

    public void enqueue(T value) {
        if (getLength() >= data.length) {
            throw new RuntimeException("The queue has full");
        }

        data[head++] = value;
        if (head == data.length) head = 0;
    }

    public T dequeue() {
        if (head == tail) return null;

        var dequeued = data[tail];
        data[tail++] = null;

        if (tail == data.length) tail = 0;

        return dequeued;
    }

    public T peek() {
        return data[tail];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        for (int i = tail; i < head; i++) {

            builder.append(" ").append(data[i]).append(",");
        }

        return builder.toString();
    }

    private int getLength() {
        if (head < tail) {
            return (head + 1) + (data.length - tail);
        }

        return (head - tail) + 1;
    }
}
