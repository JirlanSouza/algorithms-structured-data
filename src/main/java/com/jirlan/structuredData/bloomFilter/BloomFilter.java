package com.jirlan.structuredData.bloomFilter;

import org.apache.commons.codec.digest.MurmurHash3;

import java.util.BitSet;

public class BloomFilter {
    private final int hashFunctionsQuantity;
    private final int bitsQuantity;
    private final BitSet bits;

    public BloomFilter(long capacity, float tolerance) {
        bitsQuantity = bestBitsQuantity(capacity, tolerance);
        hashFunctionsQuantity = bestHashFunctionsQuantity(bitsQuantity, capacity);

        bits = new BitSet(bitsQuantity);
    }

    public void add(String value) {
        var valueHash = value.hashCode();

        for (int i = 0; i < hashFunctionsQuantity; i++) {
            var index = calculateIndex(valueHash, bitsQuantity, i);
            bits.set(index);
        }
    }

    public boolean maybeContains(String value) {
        var valueHash = value.hashCode();

        for (int i = 0; i < hashFunctionsQuantity; i++) {
            var index = calculateIndex(valueHash, bitsQuantity, i);
            if (!bits.get(index)) return false;
        }

        return true;
    }

    private static int bestBitsQuantity(long capacity, float tolerance) {
        return (int) Math.ceil((capacity * Math.log(tolerance)) / Math.log(1 / Math.pow(2, Math.log(2))));
    }

    private int bestHashFunctionsQuantity(long bitsQuantity, long capacity) {
        return (int) Math.round(((float) bitsQuantity / capacity) * Math.log(2));
    }

    private static int calculateIndex(int valueHash, int bitsQuantity, int seed) {
        var secondaryHash = MurmurHash3.hash32(valueHash, seed);
        var hash = valueHash * seed + secondaryHash;
        hash = hash & 0x7FFFFFFF;
        return hash % bitsQuantity;
    }
}
