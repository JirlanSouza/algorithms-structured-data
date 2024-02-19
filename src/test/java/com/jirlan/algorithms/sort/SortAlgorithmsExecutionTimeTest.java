package com.jirlan.algorithms.sort;

import com.jirlan.common.ExecutionTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class SortAlgorithmsExecutionTimeTest {
    private static int[] dataSet;

    @BeforeAll
    static void setData() {
        dataSet = new Random().ints().limit(100_000L).toArray();
    }

    @Test
    @DisplayName("Should sort array integer number using Bubble sort")
    void bubbleSortTest() {
        ExecutionTime.mettle("Bubble sort", dataSet.clone(), BubbleSort::sort);
    }

    @Test
    @DisplayName("Should sort array integer number using Merge sort")
    void mergeSortTest() {
        ExecutionTime.mettle("Merge sort", dataSet.clone(), MergeSort::sort);
    }

    @Test
    @DisplayName("Should sort array integer number using Quick sort")
    void quickSortTest() {
        ExecutionTime.mettle("Quick sort", dataSet.clone(), QuickSort::sort);
    }

    @Test
    @DisplayName("Should sort array integer number using Heap sort")
    void heapSortTest() {
        ExecutionTime.mettle("Heap sort", dataSet.clone(), HeapSort::sort);
    }

    @Test
    @DisplayName("Should sort array integer number using Selection sort")
    void selectionSortTest() {
        ExecutionTime.mettle("Selection sort", dataSet.clone(), SelectionSort::sort);
    }

    @Test
    @DisplayName("Should sort array integer number using insertion sort")
    void insertionSortTest() {
        ExecutionTime.mettle("Selection sort", dataSet.clone(), InsertionSort::sort);
    }

    @Test
    @DisplayName("Should sort array integer number using Arrays sort")
    void ArraysSortTest() {
        ExecutionTime.mettle("Arrays sort", dataSet.clone(), a -> {
            Arrays.sort(a);
            return a;
        });
    }
}
