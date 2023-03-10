package com.jirlan.structuredData.BinaryHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryHeap {
    private ArrayList<Integer> data;

    public BinaryHeap(int[] data) {
        this.data = (ArrayList<Integer>) Arrays.stream(data).boxed().collect(Collectors.toList());
        heapify(this.data, this.data.size());
    }

    public int[] sort() {
        heapify(data, data.size());
        for (int i = data.size() - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapify(data, i - 1, 0);
        }

        return data.stream().mapToInt(Integer::intValue).toArray();
    }

    public void insert(int value) {
        data.add(value);
        int nodeIndex = data.size() - 1;
        int parent = parent(nodeIndex);

        while (isBigger(nodeIndex, parent)) {
            swap(nodeIndex, parent);
            nodeIndex = parent;
            parent = parent(nodeIndex);
        }
    }

    public int dequeue() {
        if (data.isEmpty())
            return -1;

        int result = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        heapify(data, data.size(), 0);
        return result;
    }

    public void heapify(List<Integer> dataList, int size) {
        if (size <= 1)
            return;
        int lastIndex = size - 1;

        for (int i = (lastIndex / 2) - 1; i >= 0; i--) {
            heapify(dataList, size, i);
        }
    }

    public void heapify(List<Integer> dataList, int size, int nodeIndex) {
        int biggest = nodeIndex;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;

        if (left < size && isBigger(dataList, left, biggest)) {
            biggest = left;
        }

        if (right < size && isBigger(dataList, right, biggest)) {
            biggest = right;
        }

        if (biggest != nodeIndex) {
            swap(dataList, nodeIndex, biggest);
            heapify(dataList, size, biggest);
        }
    }

    public int left(int nodeIndex) {
        int result = (2 * nodeIndex) + 1;
        return (result < data.size()) ? result : -1;
    }

    public int right(int nodeIndex) {
        int result = (2 * nodeIndex) + 2;
        return (result < data.size()) ? result : -1;
    }

    public int parent(int nodeIndex) {
        return nodeIndex == 0 ? -1 : (nodeIndex - 1) / 2;
    }

    private boolean isBigger(int nodeIndexOne, int nodeIndexTwo) {
        return data.get(nodeIndexOne) > data.get(nodeIndexTwo);
    }

    private boolean isBigger(List<Integer> dataList, int nodeIndexOne, int nodeIndexTwo) {
        return dataList.get(nodeIndexOne) > dataList.get(nodeIndexTwo);
    }

    private void swap(int nodeIndexOne, int nodeIndexTwo) {
        int temp = data.get(nodeIndexOne);
        data.set(nodeIndexOne, data.get(nodeIndexTwo));
        data.set(nodeIndexTwo, temp);
    }

    private void swap(List<Integer> dataList, int nodeIndexOne, int nodeIndexTwo) {
        int temp = dataList.get(nodeIndexOne);
        dataList.set(nodeIndexOne, dataList.get(nodeIndexTwo));
        dataList.set(nodeIndexTwo, temp);
    }
}
