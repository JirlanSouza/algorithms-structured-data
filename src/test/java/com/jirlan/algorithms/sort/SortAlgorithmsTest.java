package com.jirlan.algorithms.sort;

import com.jirlan.common.ExecutionTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortAlgorithmsTest {

    static Stream<SortAlgorithmsDataTests.DataTest> testsData() {
        return SortAlgorithmsDataTests.getStream();
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Bubble sort")
    void bubbleSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = BubbleSort.sort(dataTest.given().clone());

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Merge sort")
    void mergeSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = MergeSort.sort(dataTest.given().clone());

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Quick sort")
    void quickSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = QuickSort.sort(dataTest.given().clone());

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Heap sort")
    void heapSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = HeapSort.sort(dataTest.given().clone());

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Selection sort")
    void selectionSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = SelectionSort.sort(dataTest.given().clone());

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Insertion sort")
    void insertionSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = InsertionSort.sort(dataTest.given().clone());

        assertArrayEquals(dataTest.expected(), sortResult);
    }
}
