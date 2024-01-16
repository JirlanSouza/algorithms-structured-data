package com.jirlan.structuredData.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int leftPad;
    private int rightPad;

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

    public List<T> listDesc() {
        ArrayList<T> list = new ArrayList<>();
        postOrderTraversal(this.root, list);

        return list;
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

    private void postOrderTraversal(Node<T> root, List<T> list) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.data);
    }

    private int height(Node<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
