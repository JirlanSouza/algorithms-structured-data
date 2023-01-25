package com.jirlan.structuredData.doublyLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void shouldCreateEmptyLinkedList() {
        var list = new DoublyLinkedList<Integer>();

        assertTrue(list.toString().equals(""));
    }

    @Test
    public void shouldPrependNodeToLinkedList() {
        var list = new DoublyLinkedList<Integer>();

        list.prepend(2);

        assertTrue(list.head.toString().equals("2"));
        assertTrue(list.tail.toString().equals("2"));

        list.prepend(3);

        assertEquals(list.head.next.previous, list.head);
        assertEquals(list.tail.previous.next, list.tail);
        assertEquals(list.tail.previous.value, 3);
        assertTrue(list.toString().equals("3, 2"));
    }

    @Test
    public void shouldAppendNodeToLinkedList() {
        var list = new DoublyLinkedList<Integer>();

        assertNull(list.head);
        assertNull(list.tail);

        list.append(1);
        list.append(2);

        assertEquals(list.head.next.value, 2);
        assertEquals(list.tail.previous.value, 1);
        assertTrue(list.toString().equals("2, 1"));
    }
}
