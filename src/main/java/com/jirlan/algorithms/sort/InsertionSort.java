package com.jirlan.algorithms.sort;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentItem = array[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                if (array[j] > currentItem) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }

            array[j + 1] = currentItem;
        }

        return array;
    }
}
