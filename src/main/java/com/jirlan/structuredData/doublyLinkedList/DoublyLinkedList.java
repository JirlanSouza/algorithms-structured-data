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

    public DoublyLinkedList<T> append(T value) {
        var newNode = new DoublyLinkedListNode<T>(value, null, null);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;

            return this;
        }

        this.tail.next = newNode;
        newNode.previous = this.tail;
        this.tail = newNode;

        return this;
    }

    public DoublyLinkedListNode<T> delete(T value) {
        if (this.head == null) {
            return null;
        }

        DoublyLinkedListNode<T> deletedNode = null;
        var currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                deletedNode = currentNode;

                if (deletedNode.equals(this.head)) {
                    this.head = this.head.next;

                    if (this.head != null) {
                        this.head.previous = null;
                    }

                    if (deletedNode.equals(this.tail)) {
                        this.tail = null;
                    }
                } else if (deletedNode.equals(this.tail)) {
                    this.tail = deletedNode.previous;
                    this.tail.next = null;
                } else {
                    var previousNode = deletedNode.previous;
                    var nextNode = deletedNode.next;
                    previousNode.next = nextNode;
                    nextNode.previous = previousNode;
                }
            }

            currentNode = currentNode.next;
        }

        return deletedNode;
    }

    public DoublyLinkedListNode<T> deleteHead() {
        if (this.head == null) {
            return null;
        }

        var deletedHead = this.head;

        if (this.head.next != null) {
            this.head = this.head.next;
            this.head.previous = null;
        } else {
            this.head = null;
            this.tail = null;
        }

        return deletedHead;
    }

    public DoublyLinkedListNode<T> deleteTail() {
        if (this.tail == null) {
            return null;
        }

        var deletedTail = this.tail;

        if (this.tail.equals(this.head)) {
            this.head = null;
            this.tail = null;

            return deletedTail;
        }

        this.tail = this.tail.previous;
        this.tail.next = null;

        return deletedTail;
    }

    public DoublyLinkedListNode<T> find(T value) {
        if (this.head == null) {
            return null;
        }

        var currentNode = this.head;
        DoublyLinkedListNode<T> foundNode = null;

        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                foundNode = currentNode;
                break;
            }

            currentNode = currentNode.next;
        }

        return foundNode;
    }
}
