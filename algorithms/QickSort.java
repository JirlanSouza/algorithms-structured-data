public class QickSort {
    public static void main(String[] args) {
        int[] unsortedData = new int[] { 451, 53, 396, 839, 225, 438, 575, 523, 977, 738, 484, 995, 42, 447, 998, 513,
                808, 26, 283, 830 };

        System.out.println();
        int[] sortedData = QickSort.sort(unsortedData);

        for (int data : sortedData) {
            System.out.print(data + ", ");
        }

        System.out.println();
    }

    public static int[] sort(int[] list) {
        QickSort.quickSort(list, 0, list.length - 1);
        return list;
    }

    private static void quickSort(int[] list, int start, int end) {
        if (start < end) {
            int partitionIndex = QickSort.partition(list, start, end);
            QickSort.quickSort(list, start, partitionIndex - 1);
            QickSort.quickSort(list, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] list, int start, int end) {
        int pivot = list[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (list[j] < pivot) {
                i++;
                QickSort.swap(list, i, j);
            }
        }

        QickSort.swap(list, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}