package com.jirlan.structuredData.BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryHeap<T extends Comparable<T>> {
    private final T[] data;
    private int size;

    public BinaryHeap(T[] data) {
        this.data = data;
        heapify(this.data, size);
    }

    public T[] sort() {
        heapify(data, size);

        for (int i = size - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapify(data, i - 1, 0);
        }

        return data;
    }

    public void insert(T value) {
        data[size] = value;
        size++;
        int nodeIndex = size - 1;
        int parent = parent(nodeIndex);

        while (parent >= 0 &&  isBigger(nodeIndex, parent)) {
            swap(nodeIndex, parent);
            nodeIndex = parent;
            parent = parent(nodeIndex);
        }
    }

    public T dequeue() {
        if (size == 0) return null;

        T result = data[0];
        data[0] = data[size - 1];
        data[size-- - 1] = null;
        heapify(data, size, 0);
        return result;
    }

    public void heapify(T[] dataList, int size) {
        if (size <= 1) return;

        int lastIndex = size - 1;

        for (int i = (lastIndex / 2) - 1; i >= 0; i--) {
            heapify(dataList, size, i);
        }
    }

    public void heapify(T[] dataList, int size, int nodeIndex) {
        int biggest = nodeIndex;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;

        if (left < size && isBigger(dataList, left, biggest)) biggest = left;
        if (right < size && isBigger(dataList, right, biggest)) biggest = right;

        if (biggest != nodeIndex) {
            swap(dataList, nodeIndex, biggest);
            heapify(dataList, size, biggest);
        }
    }

    public int left(int nodeIndex) {
        int result = (2 * nodeIndex) + 1;
        return (result < data.length) ? result : -1;
    }

    public int right(int nodeIndex) {
        int result = (2 * nodeIndex) + 2;
        return (result < data.length) ? result : -1;
    }

    public int parent(int nodeIndex) {
        return nodeIndex == 0 ? -1 : (nodeIndex - 1) / 2;
    }

    private boolean isBigger(int nodeIndexOne, int nodeIndexTwo) {
        return data[nodeIndexOne].compareTo(data[nodeIndexTwo]) > 0;
    }

    private boolean isBigger(T[] dataList, int nodeIndexOne, int nodeIndexTwo) {
        return dataList[nodeIndexOne].compareTo(dataList[nodeIndexTwo]) > 0;
    }

    private void swap(int nodeIndexOne, int nodeIndexTwo) {
        T temp = data[nodeIndexOne];
        data[nodeIndexOne] = data[nodeIndexTwo];
        data[nodeIndexTwo] = temp;
    }

    private void swap(T[] dataList, int nodeIndexOne, int nodeIndexTwo) {
        T temp = dataList[nodeIndexOne];
        dataList[nodeIndexOne] = dataList[nodeIndexTwo];
        dataList[nodeIndexTwo] = temp;
    }
}
