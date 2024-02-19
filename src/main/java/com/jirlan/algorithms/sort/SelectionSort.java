package com.jirlan.algorithms.sort;

public class SelectionSort {

    public static int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int smallerIndex = getSmallerIndex(array, i + 1, array.length - 1);

            if (array[i] > array[smallerIndex]) {
                int temp = array[i];
                array[i] = array[smallerIndex];
                array[smallerIndex] = temp;
            }
        }

        return array;
    }

    private static int getSmallerIndex(int[] array, int start, int end) {
        int smallerIndex = start;

        for (int i = start + 1; i <= end; i++) {
            if (array[i] < array[smallerIndex]) {
                smallerIndex = i;
            }
        }

        return smallerIndex;
    }
}
