package com.jirlan.algorithms.sort;

public class HeapSort {
    public static int[] sort(int[] list) {
        heapify(list, list.length);
        for (int i = list.length - 1; i >= 0; i--) {
            swap(list, 0, i);
            heapify(list, i, 0);
        }

        return list;
    }

    private static void heapify(int[] list, int size) {
        if (size <= 1)
            return;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(list, size, i);
        }
    }

    private static void heapify(int[] list, int size, int nodeIndex) {
        int biggest = nodeIndex;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;

        if (left < size && isBigger(list, left, biggest)) {
            biggest = left;
        }

        if (right < size && isBigger(list, right, biggest)) {
            biggest = right;
        }

        if (biggest != nodeIndex) {
            swap(list, nodeIndex, biggest);
            heapify(list, size, biggest);
        }
    }

    private static boolean isBigger(int[] list, int nodeIndexOne, int nodeIndexTwo) {
        return list[nodeIndexOne] > list[nodeIndexTwo];
    }

    private static void swap(int[] list, int nodeIndexOne, int nodeIndexTwo) {
        int temp = list[nodeIndexOne];
        list[nodeIndexOne] = list[nodeIndexTwo];
        list[nodeIndexTwo] = temp;
    }
}
