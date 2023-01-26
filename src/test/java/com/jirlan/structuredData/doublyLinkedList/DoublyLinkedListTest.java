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

    @Test
    public void shouldDeleteNodeFromLinkedList() {
        var linkedList = new DoublyLinkedList<Integer>();

        assertNull(linkedList.delete(5));

        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(3);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        assertEquals(linkedList.head.toString(), "1");
        assertEquals(linkedList.tail.toString(), "5");

        var deletedNode = linkedList.delete(3);
        assertEquals(deletedNode.value, 3);
        assertEquals(linkedList.tail.previous.previous.value, 2);
        assertEquals(linkedList.toString(), "1, 1, 2, 4, 5");

        linkedList.delete(3);
        assertEquals(linkedList.toString(), "1, 1, 2, 4, 5");

        linkedList.delete(1);
        assertEquals(linkedList.toString(), "2, 4, 5");

        assertEquals(linkedList.head.toString(), "2");
        assertEquals(linkedList.head.next.next, linkedList.tail);
        assertEquals(linkedList.tail.previous.previous, linkedList.head);
        assertEquals(linkedList.tail.toString(), "5");

        linkedList.delete(5);

        assertEquals(linkedList.toString(), "2, 4");

        assertEquals(linkedList.head.toString(), "2");
        assertEquals(linkedList.tail.toString(), "4");

        linkedList.delete(4);
        assertEquals(linkedList.toString(), "2");

        assertEquals(linkedList.head.toString(), "2");
        assertEquals(linkedList.tail.toString(), "2");
        assertEquals(linkedList.head, linkedList.tail);

        linkedList.delete(2);
        assertEquals(linkedList.toString(), "");
    };
}
