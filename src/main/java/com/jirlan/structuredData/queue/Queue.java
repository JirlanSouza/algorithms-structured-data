package com.jirlan.structuredData.queue;

import com.jirlan.structuredData.linkedList.LinkedList;

public class Queue<T> {
    LinkedList<T> linkedList;

    public Queue() {
        this.linkedList = new LinkedList<>();
    }

    public void enqueue(T value) {
        linkedList.append(value);
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }

    public T dequeue() {
        var dequeued = linkedList.deleteHead();
        return  dequeued.value;
    }

    public T peek() {
        if (linkedList.head == null) {
            return null;
        }

        return linkedList.head.value;
    }

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }
}
