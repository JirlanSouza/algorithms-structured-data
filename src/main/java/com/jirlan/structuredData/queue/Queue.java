package com.jirlan.structuredData.queue;

import com.jirlan.structuredData.linkedList.LinkedList;

public class Queue<T> {
    LinkedList<T> linkedList;

    public Queue() {
        this.linkedList = new LinkedList<T>();
    }
}
