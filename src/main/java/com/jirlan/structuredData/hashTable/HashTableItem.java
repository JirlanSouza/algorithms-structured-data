package com.jirlan.structuredData.hashTable;

public record HashTableItem<K extends Comparable<K>, V>(K key, V value) {
}
