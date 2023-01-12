package com.jirlan.structuredData.linkedList;

public class LinkedList<T> {
    public LinkedListNode<T> head = null;
    public LinkedListNode<T> tail = null;

    public LinkedList<T> prepend(T value) {
        this.head = new LinkedListNode<T>(value, this.head);

        if (this.tail == null) {
            this.tail = this.head;
        }

        return this;
    }

    public LinkedList<T> append(T value) {
        var newNode = new LinkedListNode<T>(value, null);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;

            return this;
        }

        this.tail.next = newNode;
        this.tail = newNode;

        return this;
    }

    public LinkedList<T> insert(T value, int rawIndex) {
        var index = rawIndex < 0 ? 0 : rawIndex;
        if (rawIndex == 0) {
            this.prepend(value);
        } else {
            var count = 1;
            var currentNode = this.head;
            var newNode = new LinkedListNode<>(value, null);

            while (currentNode != null) {
                if (count == index) {
                    break;
                }

                currentNode = currentNode.next;
                count++;
            }

            if (currentNode != null) {

            }
        }

        return this;
    }
}