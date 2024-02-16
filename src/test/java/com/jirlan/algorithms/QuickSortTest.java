package com.jirlan.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sortIntArray() {
        int[] sortedArray = QuickSort.sort(SortTestData.UNSORTED_ARRAY.clone());

        assertArrayEquals(SortTestData.EXPECTED_ARRAY, sortedArray);
    }

}