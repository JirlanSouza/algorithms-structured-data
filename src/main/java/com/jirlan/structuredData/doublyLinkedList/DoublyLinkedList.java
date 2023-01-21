package com.jirlan.structuredData.doublyLinkedList;

public class DoublyLinkedList<T> {
    DoublyLinkedListNode<T> head = null;
    DoublyLinkedListNode<T> tail = null;

    public DoublyLinkedList<T> prepend(T value) {
        var newNode = new DoublyLinkedListNode<T>(value, this.head, null);

        if (this.head != null) {
            this.head.previous = newNode;
        }

        this.head = newNode;

        if (this.tail == null) {
            this.tail = newNode;
        }

        return this;
    }

    public String toString() {
        if (this.head == null) {
            return "";
        }

        var currentNode = this.head;
        var builder = new StringBuilder();

        while (currentNode != null) {
            builder.append(currentNode.toString());

            if (currentNode.next != null) {
                builder.append(", ");
            }

            currentNode = currentNode.next;
        }

        return builder.toString();
    }
}
