package com.jirlan.algorithms;

public class QuickSort {

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);

        return array;
    }

    private static void sort(int[] array, int start, int end) {
        if (start > end) {
            return;
        }

        int partitioningIndex = partition(array, start, end);
        sort(array, start, partitioningIndex - 1);
        sort(array, partitioningIndex + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, end);

        return i;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
