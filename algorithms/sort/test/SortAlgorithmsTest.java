package sort.test;

import sort.BinaryHeap;
import sort.BubbleSort;
import sort.MergeSort;
import sort.QuickSort;

public class SortAlgorithmsTest {
    private static TestLists testLists = new TestLists(
            new int[] { 451, 53, 396, 839, 225, 438, 575, 523, 977, 738, 484, 995, 42, 447, 998,
                    513, 808, 26, 283,
                    830 },
            new int[] { 26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830,
                    839, 977, 995,
                    998, },
            new int[] { 998, 995, 977, 839, 830, 808, 738, 575, 523, 513, 484, 451, 447, 438, 396,
                    283, 225, 53, 42,
                    26, },
            new int[] { 896, 896, 896, 48, 48, 78, 78, 48, 56, 56, 56, 102, 102, 102, 296, 459, 459,
                    21, 21, 21,
                    296, 296, });

    private static TestLists expectedLists = new TestLists(
            new int[] { 26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995,
                    998 },
            new int[] { 26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830,
                    839, 977, 995,
                    998, },
            new int[] { 26, 42, 53, 225, 283, 396, 438, 447, 451, 484, 513, 523, 575, 738, 808, 830, 839, 977, 995,
                    998 },
            new int[] { 21, 21, 21, 48, 48, 48, 56, 56, 56, 78, 78, 102, 102, 102, 296, 296, 296, 459, 459, 896, 896,
                    896 });

    public static void main(String[] args) {
        quickSortTest();
        bublleSortTest();
        mergeSortTest();
        heapSortTest();
    }

    private static void quickSortTest() {
        int[] sortedAnyList = QuickSort.sort(testLists.any().clone());
        TestBase.test("QUICK SORT TEST ANY LIST", expectedLists.any(), sortedAnyList);

        int[] sortedAlreadySortedList = QuickSort.sort(testLists.alreadySorted().clone());
        TestBase.test("QUICK SORT TEST ALREADY SORTED LIST", expectedLists.alreadySorted(), sortedAlreadySortedList);

        int[] sortedInverseList = QuickSort.sort(testLists.inversedSorted().clone());
        TestBase.test("QUICK SORT TEST INVERSE SORTED LIST", expectedLists.inversedSorted(), sortedInverseList);

        int[] sortedRepeatedList = QuickSort.sort(testLists.repeadted().clone());
        TestBase.test("QUICK SORT TEST REPEATED LIST", expectedLists.repeadted(), sortedRepeatedList);

    }

    private static void bublleSortTest() {
        int[] sortedAnyList = BubbleSort.sort(testLists.any().clone(), false);
        TestBase.test("BUBBLE SORT TEST ANY LIST", expectedLists.any(), sortedAnyList);

        int[] sortedAlreadySortedList = BubbleSort.sort(testLists.alreadySorted().clone(), false);
        TestBase.test("BUBBLE SORT TEST ALREADY SORTED LIST", expectedLists.alreadySorted(), sortedAlreadySortedList);

        int[] sortedInverseList = BubbleSort.sort(testLists.inversedSorted().clone(), false);
        TestBase.test("BUBBLE SORT TEST INVERSE SORTED LIST", expectedLists.inversedSorted(), sortedInverseList);

        int[] sortedRepeatedList = BubbleSort.sort(testLists.repeadted().clone(), false);
        TestBase.test("BUBBLE SORT TEST REPEATED LIST", expectedLists.repeadted(), sortedRepeatedList);
    }

    private static void mergeSortTest() {
        int[] sortedAnyList = MergeSort.sort(testLists.any().clone());
        TestBase.test("MERGE SORT TEST ANY LIST", expectedLists.any(), sortedAnyList);

        int[] sortedAlreadySortedList = MergeSort.sort(testLists.alreadySorted().clone());
        TestBase.test("MERGE SORT TEST ALREADY SORTED LIST", expectedLists.alreadySorted(), sortedAlreadySortedList);

        int[] sortedInverseList = MergeSort.sort(testLists.inversedSorted().clone());
        TestBase.test("MERGE SORT TEST INVERSE SORTED LIST", expectedLists.inversedSorted(), sortedInverseList);

        int[] sortedRepeatedList = MergeSort.sort(testLists.repeadted().clone());
        TestBase.test("MERGE SORT TEST REPEATED LIST", expectedLists.repeadted(), sortedRepeatedList);
    }

    private static void heapSortTest() {
        int[] sortedAnyList = new BinaryHeap(testLists.any().clone()).sort();
        TestBase.test("HEAP SORT TEST ANY LIST", expectedLists.any(), sortedAnyList);

        int[] sortedAlreadySortedList = new BinaryHeap(testLists.alreadySorted().clone()).sort();
        TestBase.test("HEAP SORT TEST ALREADY SORTED LIST", expectedLists.alreadySorted(), sortedAlreadySortedList);

        int[] sortedInverseList = new BinaryHeap(testLists.inversedSorted().clone()).sort();
        TestBase.test("HEAP SORT TEST INVERSE SORTED LIST", expectedLists.inversedSorted(), sortedInverseList);

        int[] sortedRepeatedList = new BinaryHeap(testLists.repeadted().clone()).sort();
        TestBase.test("HEAP SORT TEST REPEATED LIST", expectedLists.repeadted(), sortedRepeatedList);
    }

}
