package sort.test;

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

    public static void main(String[] args) {
        quickSortTest();
    }

    private static void quickSortTest() {
        printList("Any list", Color.BLUE, testLists.any());
        int[] sortedAnyList = QuickSort.sort(testLists.any());
        printList("Sorted Any list", Color.GREEN, sortedAnyList);

        printList("Already sorted list", Color.BLUE, testLists.alreadySorted());
        int[] sortedAlreadySortedList = QuickSort.sort(testLists.alreadySorted());
        printList("Sorted Alreaddy list", Color.GREEN, sortedAlreadySortedList);

        printList("inverse list", Color.BLUE, testLists.inversedSorted());
        int[] sortedInverseList = QuickSort.sort(testLists.inversedSorted());
        printList("Sorted Inversy list", Color.GREEN, sortedInverseList);

        printList("Repeated list", Color.BLUE, testLists.repeadted());
        int[] sortedRepeatedList = QuickSort.sort(testLists.repeadted());
        printList("Sorted Inversy list", Color.GREEN, sortedRepeatedList);
    }

    private static void printList(String prefix, Color color, int[] list) {
        StringBuilder formetedPrefix = new StringBuilder();
        formetedPrefix.append(String.format("\u001b[%d;1m %-20s\u001b[0m ", color.getValue(), prefix));

        for (int listItem : list) {
            formetedPrefix.append(listItem + ", ");
        }

        formetedPrefix.delete(formetedPrefix.length() - 2, formetedPrefix.length() - 1);
        formetedPrefix.append("\n");
        System.out.println(formetedPrefix);
    }

}

final record TestLists(
        int[] any,
        int[] alreadySorted,
        int[] inversedSorted,
        int[] repeadted) {
}

enum Color {
    GREEN(42),
    BLUE(44);

    private int value;

    Color(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
