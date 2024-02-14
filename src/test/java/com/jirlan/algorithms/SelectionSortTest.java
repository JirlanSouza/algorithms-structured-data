package com.jirlan.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {
    private static final int[] UNSORTED_ARRAY = new int[]{22, 59, 89, 456, 1, 7, 45, 1295, 85};
    private static final int[] EXPECTED_ARRAY = new int[]{1, 7, 22, 45, 59, 85, 89, 456, 1295};

    @Test
    void sortArray() {
        int[] sortedArray = SelectionSort.sort(UNSORTED_ARRAY.clone());

        assertArrayEquals(EXPECTED_ARRAY, sortedArray);
    }

    @Test
    void sortArrayV2() {
        int[] sortedArray = SelectionSortV2.sort(UNSORTED_ARRAY.clone());

        assertArrayEquals(EXPECTED_ARRAY, sortedArray);
    }

}