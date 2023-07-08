package com.jirlan.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.jirlan.common.ExecutionTime;
import org.junit.jupiter.api.Test;

public class SortAlgorithmsTest {
        private static final int[] any = new int[] {
                        451, 53, 396, 839, 225, 438, 575, 523, 977, 738, 484, 995, 42, 447, 998, 513, 808, 26, 283, 830
        };

        private static final int[] alreadySorted = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
        };

        private static final int[] inverseSorted = new int[] {
                        998, 995, 977, 839, 830, 808, 738, 575, 523, 513, 484, 451, 447, 438, 396, 283, 225, 53, 42, 26
        };

        private static final int[] repeated = new int[] {
                        896, 896, 896, 48, 48, 78, 78, 48, 56, 56, 56, 102, 102, 102, 296, 459, 459, 21, 21, 21, 296,
                        296,
        };

        private static final int[] expectedAny = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
        };

        private static final int[] expectedAlreadySorted = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995,
                        998,
        };

        private static final int[] expectedInverseSorted = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
        };

        private static final int[] expectedRepeated = new int[] {
                        21, 21, 21, 48, 48, 48, 56, 56, 56, 78, 78, 102, 102, 102, 296, 296, 296, 459, 459, 896, 896,
                        896
        };

        @Test
        public void bubbleSortTest() {
                System.out.println("Bubble sort");
                var anyResult = ExecutionTime.mettle(any.clone(), BubbleSort::sort);
                var alreadySortedResult = ExecutionTime.mettle(alreadySorted.clone(), BubbleSort::sort);
                var inverseSortedResult = ExecutionTime.mettle(inverseSorted.clone(), BubbleSort::sort);
                var repeatedResult = ExecutionTime.mettle(repeated.clone(), BubbleSort::sort);

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInverseSorted, inverseSortedResult);
                assertArrayEquals(expectedRepeated, repeatedResult);
                System.out.println();
        }

        @Test
        public void mergeSortTest() {
                System.out.println("Merge sort");
                var anyResult = ExecutionTime.mettle(any.clone(), MergeSort::sort);
                var alreadySortedResult = ExecutionTime.mettle(alreadySorted.clone(), MergeSort::sort);
                var inverseSortedResult = ExecutionTime.mettle(inverseSorted.clone(), MergeSort::sort);
                var repeatedResult = ExecutionTime.mettle(repeated.clone(), MergeSort::sort);

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInverseSorted, inverseSortedResult);
                assertArrayEquals(expectedRepeated, repeatedResult);
                System.out.println();
        }

        @Test
        public void quickSortTest() {
                System.out.println("Quick sort");
                var anyResult = ExecutionTime.mettle(any.clone(), QuickSort::sort);
                var alreadySortedResult = ExecutionTime.mettle(alreadySorted.clone(), QuickSort::sort);
                var inverseSortedResult = ExecutionTime.mettle(inverseSorted.clone(), QuickSort::sort);
                var repeatedResult = ExecutionTime.mettle(repeated.clone(), QuickSort::sort);

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInverseSorted, inverseSortedResult);
                assertArrayEquals(expectedRepeated, repeatedResult);
                System.out.println();

        }

        @Test
        public void heapSortTest() {
                System.out.println("Heap sort");
                var anyResult = ExecutionTime.mettle(any.clone(), HeapSort::sort);
                var alreadySortedResult = ExecutionTime.mettle(alreadySorted.clone(), HeapSort::sort);
                var inverseSortedResult = ExecutionTime.mettle(inverseSorted.clone(), HeapSort::sort);
                var repeatedResult = ExecutionTime.mettle(repeated.clone(), HeapSort::sort);

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInverseSorted, inverseSortedResult);
                assertArrayEquals(expectedRepeated, repeatedResult);
                System.out.println();
        }

}
