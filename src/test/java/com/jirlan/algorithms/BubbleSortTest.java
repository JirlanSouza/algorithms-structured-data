package com.jirlan.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sortIntArray() {
        int[] sortedArray = BubbleSort.sort(SortTestData.UNSORTED_ARRAY.clone());

        assertArrayEquals(SortTestData.EXPECTED_ARRAY, sortedArray);
    }
}