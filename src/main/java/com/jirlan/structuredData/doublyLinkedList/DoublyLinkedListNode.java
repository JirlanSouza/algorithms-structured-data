package com.jirlan.structuredData.doublyLinkedList;

public class DoublyLinkedListNode<T> {
    T value;
    DoublyLinkedListNode<T> next;
    DoublyLinkedListNode<T> previous;

    DoublyLinkedListNode(T value, DoublyLinkedListNode<T> next, DoublyLinkedListNode<T> previus) {
        this.value = value;
        this.next = next;
        this.previous = previus;
    }

    public String toString() {
        return this.value.toString();
    }
}
