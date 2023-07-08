package com.jirlan.structuredData.stack;

import com.jirlan.structuredData.linkedList.LinkedList;

public class Stack<T> {
    private final LinkedList<T> data;

    public Stack() {
        this.data = new LinkedList<>();
    }

    public void push(T item) {
        this.data.append(item);
    }

    public T pop() {
        var item = this.data.deleteTail();

        if (item == null) return null;

        return item.value;
    }

    public T peek() {
        return this.data.tail.value;
    }

    public boolean isEmpty() {
        return this.data.size() <= 0;
    }
}
