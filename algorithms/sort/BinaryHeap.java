package sort;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    private static List<Integer> data = new ArrayList<Integer>();

    public static Integer[] sort(List<Integer> dataList) {
        heapify(dataList, dataList.size());
        for (int i = dataList.size() - 1; i >= 0; i--) {
            swap(dataList, 0, i);
            heapify(dataList, i - 1, 0);
        }

        return (Integer[]) dataList.toArray();
    }

    public static void insert(int value) {
        data.add(value);
        int nodeIndex = data.size() - 1;
        int parent = parent(nodeIndex);

        while (isBigger(nodeIndex, parent)) {
            swap(nodeIndex, parent);
            nodeIndex = parent;
            parent = parent(nodeIndex);
        }
    }

    public static int dequeue() {
        if (data.isEmpty())
            return -1;

        int result = data.get(0);
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);
        heapify(data, data.size(), 0);
        return result;
    }

    public static void heapify(List<Integer> dataList, int size) {
        if (size <= 1)
            return;
        int lastIndex = size - 1;

        for (int i = (lastIndex / 2) - 1; i >= 0; i--) {
            heapify(dataList, size, i);
        }
    }

    public static void heapify(List<Integer> dataList, int size, int nodeIndex) {
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

    public static int left(int nodeIndex) {
        int result = (2 * nodeIndex) + 1;
        return (result < data.size()) ? result : -1;
    }

    public static int right(int nodeIndex) {
        int result = (2 * nodeIndex) + 2;
        return (result < data.size()) ? result : -1;
    }

    public static int parent(int nodeIndex) {
        return nodeIndex == 0 ? -1 : (nodeIndex - 1) / 2;
    }

    private static boolean isBigger(int nodeIndexOne, int nodeIndexTwo) {
        return data.get(nodeIndexOne) > data.get(nodeIndexTwo);
    }

    private static boolean isBigger(List<Integer> dataList, int nodeIndexOne, int nodeIndexTwo) {
        return dataList.get(nodeIndexOne) > dataList.get(nodeIndexTwo);
    }

    private static void swap(int nodeIndexOne, int nodeIndexTwo) {
        int temp = data.get(nodeIndexOne);
        data.set(nodeIndexOne, data.get(nodeIndexTwo));
        data.set(nodeIndexTwo, temp);
    }

    private static void swap(List<Integer> dataList, int nodeIndexOne, int nodeIndexTwo) {
        int temp = dataList.get(nodeIndexOne);
        dataList.set(nodeIndexOne, dataList.get(nodeIndexTwo));
        dataList.set(nodeIndexTwo, temp);
    }
}
