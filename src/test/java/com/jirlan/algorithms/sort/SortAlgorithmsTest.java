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
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Merge sort")
    void mergeSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Quick sort")
    void quickSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
    }

    @ParameterizedTest
    @MethodSource("testsData")
    @DisplayName("Should sort array integer number using Heap sort")
    void heapSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
    }

}
