package com.jirlan.structuredData.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T data) {
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

    public List<T> preOrderTraversal() {
        ArrayList<T> list = new ArrayList<>();
        preOrderTraversal(this.root, list);

        return list;
    }

    public List<T> inOrderTraversal() {
        ArrayList<T> list = new ArrayList<>();
        inOrderTraversal(this.root, list);

        return list;
    }

    public List<T> postOrderTraversal() {
        ArrayList<T> list = new ArrayList<>();
        postOrderTraversal(this.root, list);

        return list;
    }

    public int height() {
        return height(this.root);
    }

    private void preOrderTraversal(Node<T> root, List<T> list) {
        if (root == null) return;

        list.add(root.data);
        inOrderTraversal(root.left, list);
        inOrderTraversal(root.right, list);

    }

    private void inOrderTraversal(Node<T> root, List<T> list) {
        if (root == null) return;

        inOrderTraversal(root.left, list);
        list.add(root.data);
        inOrderTraversal(root.right, list);

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
