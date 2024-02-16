package com.jirlan.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {
    @Test
    void sortArray() {
        int[] sortedArray = SelectionSort.sort(SortTestData.UNSORTED_ARRAY.clone());

        assertArrayEquals(SortTestData.EXPECTED_ARRAY, sortedArray);
    }

    @Test
    void sortArrayV2() {
        int[] sortedArray = SelectionSortV2.sort(SortTestData.UNSORTED_ARRAY.clone());

        assertArrayEquals(SortTestData.EXPECTED_ARRAY, sortedArray);
    }

}