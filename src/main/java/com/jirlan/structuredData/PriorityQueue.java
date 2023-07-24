package com.jirlan.structuredData;

import com.jirlan.structuredData.BinaryHeap.BinaryHeap;

import java.lang.reflect.Array;

public class PriorityQueue<T extends Comparable<T>> {
    private final BinaryHeap<T> binaryHeap;
    public PriorityQueue(int capacity, Class<T> type) {
        T[] data = (T[]) Array.newInstance(type, capacity);
        binaryHeap = new BinaryHeap<T>(data);
    }

    public void insert(T value) {
        binaryHeap.insert(value);
    }

    public T dequeue() {
        return binaryHeap.dequeue();
    }
}
