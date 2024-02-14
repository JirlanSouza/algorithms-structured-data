package com.jirlan.algorithms;

public class SelectionSortV2 {

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int smallerIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallerIndex]) {
                    smallerIndex = j;
                }

            }

            if (smallerIndex != i) {
                swap(array, i, smallerIndex);
            }

        }

        return array;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
