package com.jirlan.structuredData.doublyLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DoublyLinkedListNodeTest {

    @Test
    public void shouldCreateListNodeWithValue() {
        var node = new DoublyLinkedListNode<Integer>(1, null, null);

        assertEquals(node.value, 1);
        assertNull(node.next);
        assertNull(node.previous);
    };

    @Test
    public void shouldLinkNodesTogether() {
        var node2 = new DoublyLinkedListNode<Integer>(2, null, null);
        var node1 = new DoublyLinkedListNode<Integer>(1, node2, null);
        var node3 = new DoublyLinkedListNode<Integer>(10, node1, node2);

        assertNotNull(node1.next);
        assertNull(node1.previous);
        assertNull(node2.next);
        assertNull(node2.previous);
        assertNotNull(node3.next);
        assertNotNull(node3.previous);
        assertEquals(node1.value, 1);
        assertEquals(node1.next.value, 2);
        assertEquals(node3.next.value, 1);
        assertEquals(node3.previous.value, 2);
    };

    @Test
    public void shouldConvertNodeToString() {
        var node = new DoublyLinkedListNode<Integer>(1, null, null);

        assertTrue(node.toString().equals("1"));
    };

}