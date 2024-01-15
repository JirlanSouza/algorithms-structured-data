package com.jirlan.structuredData.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node<T> current = this.root;
        Node<T> parent;

        while (true) {
            parent = current;

            if (data.compareTo(current.data) < 0) {
                current = current.left;

                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;

                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    public List<T> listAsc() {
        return inOrderTraversal(this.root);
    }

    private List<T> inOrderTraversal(Node<T> root) {
        var list = new ArrayList<T>();

        if (root != null) {
            list.addAll(inOrderTraversal(root.left));
            list.add(root.data);
            list.addAll(inOrderTraversal(root.right));
        }

        return list;
    }

    @Override
    public String toString() {
        return this.root.toString();
    }
}
