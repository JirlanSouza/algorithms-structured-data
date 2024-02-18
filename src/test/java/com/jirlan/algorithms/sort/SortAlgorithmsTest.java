package com.jirlan.algorithms.sort;

import com.jirlan.common.ExecutionTime;
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
    public void bubbleSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        System.out.println("Bubble sort");
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
        System.out.println();
    }

    @ParameterizedTest
    @MethodSource("testsData")
    public void mergeSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        System.out.println("Merge sort");
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
        System.out.println();
    }

    @ParameterizedTest
    @MethodSource("testsData")
    public void quickSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        System.out.println("Quick sort");
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
        System.out.println();
    }

    @ParameterizedTest
    @MethodSource("testsData")
    public void heapSortTest(SortAlgorithmsDataTests.DataTest dataTest) {
        System.out.println("Heap sort");
        var sortResult = ExecutionTime.mettle(dataTest.given().clone(), BubbleSort::sort);

        assertArrayEquals(dataTest.expected(), sortResult);
        System.out.println();
    }

}
