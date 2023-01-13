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
}
