package com.jirlan.structuredData.linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @Test
    public void createEmptyList() {
        var list = new LinkedList<>();

        assertEquals(list.size(), 0);
    }

    @Test
    public void appendNodeToLinkedList() {
        var list = new LinkedList<Integer>();

        assertNull(list.head);
        assertNull(list.tail);

        list.append(200);
        list.append(300);

        assertEquals(list.size(), 2);
    }

    @Test
    public void prependNodeToLinkedList() {
        var list = new LinkedList<Integer>();

        list.prepend(2);
        list.append(1);
        list.prepend(3);

        assertEquals(list.toString(), " 3, 2, 1,");
    }

    @Test
    public void insertNodeToLinkedList() {
        var list = new LinkedList<Integer>();

        list.insert(4, 3);
        list.insert(3, 2);
        list.insert(2, 1);
        list.insert(1, -7);
        list.insert(10, 9);

        System.out.println(list);

        assertEquals(list.toString(), " 1, 4, 2, 3, 10,");
    }
}