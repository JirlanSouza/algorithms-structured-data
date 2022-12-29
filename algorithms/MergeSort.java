public class MergeSort {
    public static void main(String[] args) {
        int[] unsortedData = new int[] { 451, 53, 396, 839, 225, 438, 575, 523, 977, 738, 484, 995, 42, 447, 998, 513,
                808, 26, 283, 830 };

        System.out.println();
        int[] sortedData = MergeSort.sort(unsortedData);

        for (int data : sortedData) {
            System.out.print(data + ", ");
        }

        System.out.println();
    }

    public static int[] sort(int[] data) {
        MergeSort.merge(data, data.length);
        return data;
    }

    private static void merge(int[] data, int length) {
        if (length < 2)
            return;
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = data[i];
        }

        for (int i = mid; i < length; i++) {
            right[i - mid] = data[i];
        }

        MergeSort.merge(left, mid);
        MergeSort.merge(right, length - mid);
        MergeSort.intercalate(data, left, right);
    }

    private static void intercalate(int[] data, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int dataIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                data[dataIndex++] = left[leftIndex++];
            } else {
                data[dataIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            data[dataIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            data[dataIndex++] = right[rightIndex++];
        }

    }
}