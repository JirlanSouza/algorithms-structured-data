package com.jirlan.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SortAlgorithmsTest {
        private static int[] any = new int[] {
                        451, 53, 396, 839, 225, 438, 575, 523, 977, 738, 484, 995, 42, 447, 998, 513, 808, 26, 283, 830
        };

        private static int[] alreadySorted = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
        };

        private static int[] inversedSorted = new int[] {
                        998, 995, 977, 839, 830, 808, 738, 575, 523, 513, 484, 451, 447, 438, 396, 283, 225, 53, 42, 26
        };

        private static int[] repeadted = new int[] {
                        896, 896, 896, 48, 48, 78, 78, 48, 56, 56, 56, 102, 102, 102, 296, 459, 459, 21, 21, 21, 296,
                        296,
        };

        private static int[] expectedAny = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
        };

        private static int[] expectedAlreadySorted = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995,
                        998,
        };

        private static int[] expectedInversedSorted = new int[] {
                        26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995, 998
        };

        private static int[] expectedRepeadted = new int[] {
                        21, 21, 21, 48, 48, 48, 56, 56, 56, 78, 78, 102, 102, 102, 296, 296, 296, 459, 459, 896, 896,
                        896
        };

        @Test
        public void bublleSortTest() {
                var anyResult = BubbleSort.sort(any.clone(), false);
                var alreadySortedResult = BubbleSort.sort(alreadySorted.clone(), false);
                var inversedSortedResult = BubbleSort.sort(inversedSorted.clone(), false);
                var repeadtedResult = BubbleSort.sort(repeadted.clone(), false);

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInversedSorted, inversedSortedResult);
                assertArrayEquals(expectedRepeadted, repeadtedResult);
        }

        @Test
        public void mergeSortTest() {
                var anyResult = MergeSort.sort(any.clone());
                var alreadySortedResult = MergeSort.sort(alreadySorted.clone());
                var inversedSortedResult = MergeSort.sort(inversedSorted.clone());
                var repeadtedResult = MergeSort.sort(repeadted.clone());

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInversedSorted, inversedSortedResult);
                assertArrayEquals(expectedRepeadted, repeadtedResult);
        }

        @Test
        public void quickSortTest() {
                var anyResult = QuickSort.sort(any.clone());
                var alreadySortedResult = QuickSort.sort(alreadySorted.clone());
                var inversedSortedResult = QuickSort.sort(inversedSorted.clone());
                var repeadtedResult = QuickSort.sort(repeadted.clone());

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInversedSorted, inversedSortedResult);
                assertArrayEquals(expectedRepeadted, repeadtedResult);

        }

        @Test
        public void heapSortTest() {
                var anyResult = HeapSort.sort(any.clone());
                var alreadySortedResult = HeapSort.sort(alreadySorted.clone());
                var inversedSortedResult = HeapSort.sort(inversedSorted.clone());
                var repeadtedResult = HeapSort.sort(repeadted.clone());

                assertArrayEquals(expectedAny, anyResult);
                assertArrayEquals(expectedAlreadySorted, alreadySortedResult);
                assertArrayEquals(expectedInversedSorted, inversedSortedResult);
                assertArrayEquals(expectedRepeadted, repeadtedResult);
        }

}
