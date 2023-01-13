package com.jirlan.structuredData.linkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class LinkedListNodeTest {
    @Test
    public void createListNodeWithValue() {
        var node = new LinkedListNode<Integer>(200, null);

        assertEquals(node.value, 200);
        assertNull(node.next);
    }

    @Test
    public void linkNodesTogether() {
        var node2 = new LinkedListNode<Integer>(200, null);
        var node1 = new LinkedListNode<Integer>(300, node2);

        assertNotNull(node1.next);
        assertNull(node2.next);
        assertEquals(node1.value, 300);
        assertEquals(node2.value, 200);
    }
}
