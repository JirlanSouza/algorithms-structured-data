package com.jirlan.structuredData.hashTable;

import com.jirlan.structuredData.linkedList.LinkedList;

import java.lang.reflect.Array;

public class HashTable<K extends Comparable<K>, V> {
    private final LinkedList<HashTableItem<K, V>>[] data;

    public HashTable() {
        data = (LinkedList<HashTableItem<K, V>>[]) Array.newInstance(LinkedList.class, 16);
    }

    public void add(K key, V value) {
        var index = getIndex(key.hashCode());
        var indexItems = data[index];

        if (indexItems == null) {
            indexItems = new LinkedList<>();
            indexItems.append(new HashTableItem<>(key, value));
            data[index] = indexItems;

            return;
        }

        var currentItem = indexItems.head;

        while (currentItem.next != null) {
            if (currentItem.value.key().equals(key)) {
                throw new IllegalArgumentException("The key already exists");
            }

            currentItem = currentItem.next;
        }

        indexItems.append(new HashTableItem<>(key, value));
    }

    public V get(K key) {
        var index = getIndex(key.hashCode());
        var indexItems = data[index];

        if (indexItems == null) return null;
        var currentItem = indexItems.head;

        while (currentItem != null) {

            if (currentItem.value.key().equals(key)) {
                return currentItem.value.value();
            }

            currentItem = currentItem.next;
        }

        return null;
    }

    private int getIndex(int hashCode) {
        return Math.max((hashCode % data.length) - 1, 0);
    }
}
