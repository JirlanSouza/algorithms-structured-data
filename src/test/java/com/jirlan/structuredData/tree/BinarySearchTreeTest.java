package com.jirlan.structuredData.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @Test
    public void shouldInsertDataIntoTreeInAscOrder() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        var dataList = new Integer[]{45, 89, 1, 56, 41, 78, 63, 25};

        for (Integer data : dataList) {
            tree.insert(data);
        }

        assertEquals(List.of(1, 25, 41, 45, 56, 63, 78, 89), tree.listAsc());
    }
}