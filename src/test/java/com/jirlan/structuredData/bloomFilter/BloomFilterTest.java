package com.jirlan.structuredData.bloomFilter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    public void shouldContainTheAddedValue() {
        var value = "value1";
        var bloomFilter = new BloomFilter(1000, 0.0001f);

        bloomFilter.add(value);

        assertTrue(bloomFilter.maybeContains(value));
    }
    @Test
    public void shouldContainTheAddedValueWithManyAddedValues() {
        var value = "value1";
        var bloomFilter = new BloomFilter(1000, 0.0001f);

        bloomFilter.add(value);

        for (int i = 0; i < 600; i++) {
            bloomFilter.add("values" + i + Math.random());
        }

        assertTrue(bloomFilter.maybeContains(value));
    }

    @Test
    public void shouldNotContainTheNotAddedValue() {
        var value = "value";
        var bloomFilter = new BloomFilter(1000, 0.0001f);

        for (int i = 0; i < 600; i++) {
            bloomFilter.add("values" + i + Math.random());
        }

        assertFalse(bloomFilter.maybeContains(value));
    }

    @Test
    public void shouldNotContainTheNotAddedValueWithClearBloomFilter() {
        var value = "value";
        var bloomFilter = new BloomFilter(1000, 0.0001f);

        assertFalse(bloomFilter.maybeContains(value));
    }
}