package sort;

public class QuickSort {
    /*
     * Complexidade assintótica
     * Pior caso: O(n²)
     * Melhor caso: Ω(n log n)
     */

    public static int[] sort(int[] list) {
        QuickSort.quickSort(list, 0, list.length - 1);
        return list;
    }

    private static void quickSort(int[] list, int start, int end) {
        if (start < end) {
            int partitionIndex = QuickSort.partition(list, start, end);
            QuickSort.quickSort(list, start, partitionIndex - 1);
            QuickSort.quickSort(list, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] list, int start, int end) {
        int pivot = list[end];
        int i = start;

        for (int j = start; j <= end; j++) {
            if (list[j] < pivot) {
                QuickSort.swap(list, i, j);
                i++;
            }
        }

        QuickSort.swap(list, i, end);
        return i;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}