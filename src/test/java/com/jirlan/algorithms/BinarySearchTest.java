package com.jirlan.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void searchInList() {
        int[] list = new int[]{2, 9, 15, 22, 59, 78, 92, 126};

        int itemIndex = BinarySearch.search(list, 15);

        assertEquals(2, itemIndex);
    }
}