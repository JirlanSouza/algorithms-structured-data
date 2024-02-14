package com.jirlan.algorithms;

public class SelectionSort {

    public static int[] sort(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int smaller = findSmaller(array);
            newArray[i] = array[smaller];
            array[smaller] = Integer.MAX_VALUE;
        }

        return newArray;
    }

    private static int findSmaller(int[] array) {
        int smallerIndex = 0;
        int smaller = array[smallerIndex];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smaller) {
                smaller = array[i];
                smallerIndex = i;
            }
        }

        return smallerIndex;
    }



}
