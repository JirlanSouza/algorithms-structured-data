package com.jirlan.algorithms;

public class BubbleSort {

    public static int[] sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int changes = 0;

            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    changes++;
                }
            }

            if (changes <= 0) {
                break;
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
