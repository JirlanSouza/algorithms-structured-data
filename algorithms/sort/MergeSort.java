package sort;

public class MergeSort {
    public static int[] sort(int[] data) {
        MergeSort.merge(data, data.length);
        return data;
    }

    private static void merge(int[] data, int length) {
        if (length < 2) {
            return;
        }

        int mid = length / 2;
        int[] left = MergeSort.copyDataSlice(data, 0, mid);
        int[] right = MergeSort.copyDataSlice(data, mid, length);

        MergeSort.merge(left, mid);
        MergeSort.merge(right, length - mid);
        MergeSort.intercalateOtimized(data, left, right);
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

    private static void intercalateOtimized(int[] data, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;

        for (int dataIndex = 0; dataIndex < data.length; dataIndex++) {
            if (leftIndex >= left.length) {
                data[dataIndex] = right[rightIndex++];

            } else if (rightIndex >= right.length) {
                data[dataIndex] = left[leftIndex++];

            } else if (left[leftIndex] < right[rightIndex]) {
                data[dataIndex] = left[leftIndex++];

            } else {
                data[dataIndex] = right[rightIndex++];
            }

        }

    }

    private static int[] copyDataSlice(int[] data, int start, int end) {
        int[] dataSlice = new int[end - start];
        for (int i = start; i < end; i++) {
            dataSlice[i - start] = data[i];
        }

        return dataSlice;
    }
}