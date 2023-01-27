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
        var list = new DoublyLinkedList<Integer>();

        assertNull(list.delete(5));

        list.append(1);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);
        list.append(4);
        list.append(5);

        assertEquals(list.head.toString(), "1");
        assertEquals(list.tail.toString(), "5");

        var deletedNode = list.delete(3);
        assertEquals(deletedNode.value, 3);
        assertEquals(list.tail.previous.previous.value, 2);
        assertEquals(list.toString(), "1, 1, 2, 4, 5");

        list.delete(3);
        assertEquals(list.toString(), "1, 1, 2, 4, 5");

        list.delete(1);
        assertEquals(list.toString(), "2, 4, 5");

        assertEquals(list.head.toString(), "2");
        assertEquals(list.head.next.next, list.tail);
        assertEquals(list.tail.previous.previous, list.head);
        assertEquals(list.tail.toString(), "5");

        list.delete(5);

        assertEquals(list.toString(), "2, 4");

        assertEquals(list.head.toString(), "2");
        assertEquals(list.tail.toString(), "4");

        list.delete(4);
        assertEquals(list.toString(), "2");

        assertEquals(list.head.toString(), "2");
        assertEquals(list.tail.toString(), "2");
        assertEquals(list.head, list.tail);

        list.delete(2);
        assertEquals(list.toString(), "");
    };

    @Test
    public void shouldDeleteLinkedListHead() {
        var list = new DoublyLinkedList<Integer>();

        assertNull(list.deleteHead());

        list.append(1);
        list.append(2);

        assertEquals(list.head.toString(), "1");
        assertEquals(list.tail.toString(), "2");

        var deletedNode1 = list.deleteHead();

        assertEquals(deletedNode1.value, 1);
        assertNull(list.head.previous);
        assertEquals(list.toString(), "2");
        assertEquals(list.head.toString(), "2");
        assertEquals(list.tail.toString(), "2");

        var deletedNode2 = list.deleteHead();

        assertEquals(deletedNode2.value, 2);
        assertEquals(list.toString(), "");
        assertNull(list.head);
        assertNull(list.tail);
    };

    @Test
    public void shouldDeleteLinkedListTail() {
        var linkedList = new DoublyLinkedList<Integer>();

        assertNull(linkedList.deleteTail());

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        assertEquals(linkedList.head.toString(), "1");
        assertEquals(linkedList.tail.toString(), "3");

        var deletedNode1 = linkedList.deleteTail();

        assertEquals(deletedNode1.value, 3);
        assertEquals(linkedList.toString(), "1, 2");
        assertEquals(linkedList.head.toString(), "1");
        assertEquals(linkedList.tail.toString(), "2");

        var deletedNode2 = linkedList.deleteTail();

        assertEquals(deletedNode2.value, 2);
        assertEquals(linkedList.toString(), "1");
        assertEquals(linkedList.head.toString(), "1");
        assertEquals(linkedList.tail.toString(), "1");

        var deletedNode3 = linkedList.deleteTail();

        assertEquals(deletedNode3.value, 1);
        assertEquals(linkedList.toString(), "");
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    };
}
