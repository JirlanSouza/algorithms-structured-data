package com.jirlan.structuredData.linkedList;

import java.util.function.Function;

public class LinkedList<T> {
    public static <T> LinkedList<T> fromArray(T[] values) {
        var linkedList = new LinkedList<T>();
        for (T value : values) {
            linkedList.append(value);
        }

        return linkedList;
    }

    public LinkedListNode<T> head = null;
    public LinkedListNode<T> tail = null;

    private int listSize = 0;

    public LinkedList<T> prepend(T value) {
        this.head = new LinkedListNode<T>(value, this.head);

        if (this.tail == null) {
            this.tail = this.head;
        }

        return this;
    }

    public LinkedList<T> append(T value) {
        var newNode = new LinkedListNode<T>(value, null);
        this.listSize++;

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
        this.listSize++;

        if (index == 0) {
            this.prepend(value);
            return this;
        }

        var count = 1;
        var currentNode = this.head;
        var newNode = new LinkedListNode<T>(value, null);

        while (currentNode != null) {
            if (count == index) {
                break;
            }

            currentNode = currentNode.next;
            count++;
        }

        if (currentNode != null) {
            newNode.next = currentNode.next;
            currentNode.next = newNode;

            return this;
        }

        if (this.tail != null) {
            this.tail.next = newNode;
            this.tail = newNode;
        } else {
            this.head = newNode;
            this.tail = newNode;
        }

        return this;
    }

    public LinkedListNode<T> delete(T value) {
        if (this.head == null) {
            return null;
        }

        LinkedListNode<T> deletedNode = null;

        while (this.head != null && this.head.value.equals(value)) {
            deletedNode = this.head;
            this.head = this.head.next;
        }

        var currentNode = this.head;

        if (currentNode != null) {
            while (currentNode.next != null) {
                if (currentNode.next.value.equals(value)) {
                    deletedNode = currentNode.next;
                    currentNode.next = currentNode.next.next;
                } else {
                    currentNode = currentNode.next;
                }
            }
        }

        if (this.tail.value.equals(value)) {
            this.tail = currentNode;
        }

        if (deletedNode != null) {
            this.listSize--;
        }

        return deletedNode;
    }

    public LinkedListNode<T> find(T value, Function<T, Boolean> callback) {
        if (this.head == null) {
            return null;
        }

        var currentNode = this.head;

        while (currentNode != null) {
            if (callback.apply(currentNode.value)) {
                return currentNode;
            }

            currentNode = currentNode.next;
        }

        return null;
    }

    public LinkedListNode<T> deleteTail() {
        var deletedTail = this.tail;

        if (this.head.equals(this.tail)) {
            this.head = null;
            this.tail = null;
            this.listSize--;

            return deletedTail;
        }

        var currentNode = this.head;

        while (currentNode.next != null) {
            if (currentNode.next.next == null) {
                currentNode.next = null;
            } else {
                currentNode = currentNode.next;
            }
        }

        this.tail = currentNode;
        this.listSize--;

        return deletedTail;
    }

    public LinkedListNode<T> deleteHead() {
        if (this.head == null) {
            return null;
        }

        var deletedHead = this.head;

        if (this.head.next != null) {
            this.head = this.head.next;
        } else {
            this.head = null;
            this.tail = null;
        }

        this.listSize--;

        return deletedHead;
    }

    public T[] toArray(T[] array) {
        var currentNode = this.head;

        for (int i = 0; i < array.length; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    public String toString() {
        var builder = new StringBuilder();
        var currentNode = this.head;

        while (currentNode != null) {
            builder.append(" " + currentNode + ",");
            currentNode = currentNode.next;
        }

        return builder.toString();
    }

    public LinkedList<T> reverse() {
        var currentNode = this.head;
        LinkedListNode<T> previusNode = null;
        LinkedListNode<T> nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previusNode;
            previusNode = currentNode;
            currentNode = nextNode;
        }

        this.tail = this.head;
        this.head = previusNode;

        return this;
    }

    public int size() {
        return this.listSize;
    }
}