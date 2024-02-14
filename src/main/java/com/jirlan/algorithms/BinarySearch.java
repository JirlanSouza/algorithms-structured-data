package com.jirlan.algorithms;

public class BinarySearch {

    public static int search(int[] list, int item) {
        int start = 0;
        int end = list.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int guess = list[middle];

            if (guess == item) {
                return middle;
            }

            if (guess < item) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }
}
