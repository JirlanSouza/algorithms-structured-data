package com.jirlan.structuredData.tree;

import com.jirlan.structuredData.queue.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (Objects.isNull(this.root)) {
            this.root = newNode;
            return;
        }

        Node<T> current = this.root;
        Node<T> parent;

        while (true) {
            parent = current;

            if (data.compareTo(current.data) < 0) {
                current = current.left;

                if (Objects.isNull(current)) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;

                if (Objects.isNull(current)) {
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

    public List<T> levelOrderTraversal() {
        ArrayList<T> list = new ArrayList<>();
        Queue<Node<T>> queue = new Queue<>();

        queue.enqueue(this.root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.dequeue();

            if (Objects.nonNull(current.left)) {
                queue.enqueue(current.left);
            }

            if (Objects.nonNull(current.right)) {
                queue.enqueue(current.right);
            }

            list.add(current.data);
        }

        return list;
    }

    public int height() {
        return height(this.root);
    }

    private void preOrderTraversal(Node<T> root, List<T> list) {
        if (Objects.isNull(root)) {
            return;
        }

        list.add(root.data);
        inOrderTraversal(root.left, list);
        inOrderTraversal(root.right, list);

    }

    private void inOrderTraversal(Node<T> root, List<T> list) {
        if (Objects.isNull(root)) {
            return;
        }

        inOrderTraversal(root.left, list);
        list.add(root.data);
        inOrderTraversal(root.right, list);

    }

    private void postOrderTraversal(Node<T> root, List<T> list) {
        if (Objects.isNull(root)) {
            return;
        }

        postOrderTraversal(root.left, list);
        postOrderTraversal(root.right, list);
        list.add(root.data);
    }

    private int height(Node<T> root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
