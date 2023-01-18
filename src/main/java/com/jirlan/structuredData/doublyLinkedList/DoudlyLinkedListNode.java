package com.jirlan.structuredData.doublyLinkedList;

public class DoudlyLinkedListNode<T> {
    T value;
    DoudlyLinkedListNode<T> next;
    DoudlyLinkedListNode<T> previus;

    DoudlyLinkedListNode(T value, DoudlyLinkedListNode<T> next, DoudlyLinkedListNode<T> previus) {
        this.value = value;
        this.next = next;
        this.previus = previus;
    }

    public String toString() {
        return this.value.toString();
    }
}
