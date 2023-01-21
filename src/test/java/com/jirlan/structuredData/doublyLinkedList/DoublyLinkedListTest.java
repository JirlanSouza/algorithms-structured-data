package com.jirlan.structuredData.doublyLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

    @Test
    public void shouldCreateEmptyLinkedList() {
        var list = new DoublyLinkedList<Integer>();

        assertTrue(list.toString().equals(""));
    }

    @Test
    public void sholdPrependNodeToLinkedList() {
        var list = new DoublyLinkedList<Integer>();

        list.prepend(2);

        assertTrue(list.head.toString().equals("2"));
        assertTrue(list.tail.toString().equals("2"));

        list.prepend(3);

        assertEquals(list.head.next.previous, list.head);
        assertEquals(list.tail.previous.next, list.tail);
        assertEquals(list.tail.previous.value, 3);
        System.out.println(list);
        assertTrue(list.toString().equals("3, 2"));
    }
}
