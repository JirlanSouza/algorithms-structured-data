package com.jirlan.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {

    @Test
    void sortArray() {
        int[] unsortedArray = new int[]{22, 59, 89, 456, 1, 7, 45, 1295, 85};

        int[] sortedArray = SelectionSort.sort(unsortedArray);

        int[] expectedArray = new int[]{1, 7, 22, 45, 59, 85, 89, 456, 1295};
        assertArrayEquals(expectedArray, sortedArray);
    }

}