package com.jirlan.structuredData.hashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HashTableTest {

    @Test
    public void shouldNotFoundNonexistentKey() {
        var hashTable = new HashTable<String, Integer>();
        hashTable.add("Item1", 20);
        hashTable.add("Item2", 200);
        hashTable.add("Item3", 5);
        hashTable.add("Item4", 28);
        hashTable.add("Item5", 48);

        var value = hashTable.get("Item20");

        assertNull(value);
    }

    @Test
    public void shouldReturnTheValueOfExistentKey() {
        var hashTable = new HashTable<String, Integer>();
        hashTable.add("Item1", 20);
        var value = hashTable.get("Item1");

        assertEquals(value, 20);
    }

    @Test
    public void shouldReturnAllValuesOfExistingKey() {
        var hashTable = new HashTable<String, Integer>();
        hashTable.add("Item1", 20);
        hashTable.add("Item2", 200);
        hashTable.add("Item3", 5);
        hashTable.add("Item4", 28);
        hashTable.add("Item5", 48);
        hashTable.add("Item6", 278);
        hashTable.add("Item7", 102);
        hashTable.add("Item8", 3);
        hashTable.add("Item9", 2060);
        hashTable.add("Item10", 1082);

        var value1 = hashTable.get("Item4");
        var value2 = hashTable.get("Item9");
        var value3 = hashTable.get("Item1");
        var value4 = hashTable.get("Item7");
        var value5 = hashTable.get("Item10");

        assertEquals(value1, 28);
        assertEquals(value2, 2060);
        assertEquals(value3, 20);
        assertEquals(value4, 102);
        assertEquals(value5, 1082);
    }
}