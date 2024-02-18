package com.jirlan.structuredData.tree;

public class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(T data) {
        this.data = data;

    }

    @Override
    public String toString() {
        return "     %s\n    /  \\\n%s     %s".formatted(this.data, this.left, this.right);
    }
}
