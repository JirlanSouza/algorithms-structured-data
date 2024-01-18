package com.jirlan.structuredData.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {
    private final Integer[] dataList = new Integer[]{45, 89, 1, 56, 41, 78, 63, 25};

    @Test
    public void preorderTreeTraversal() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (Integer data : dataList) {
            tree.insert(data);
        }

        assertEquals(List.of(45, 1, 25, 41, 56, 63, 78, 89), tree.preOrderTraversal());
    }

    @Test
    public void inorderTreeTraversal() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (Integer data : dataList) {
            tree.insert(data);
        }

        assertEquals(List.of(1, 25, 41, 45, 56, 63, 78, 89), tree.inOrderTraversal());
    }

    @Test
    public void postOrderTreeTraversal() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (Integer data : dataList) {
            tree.insert(data);
        }

        assertEquals(List.of(25, 41, 1, 63, 78, 56, 89, 45), tree.postOrderTraversal());
    }

    @Test
    public void shouldReturnTreeHeight() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        for (Integer data : dataList) {
            tree.insert(data);
        }

        assertEquals(5, tree.height());
    }
}