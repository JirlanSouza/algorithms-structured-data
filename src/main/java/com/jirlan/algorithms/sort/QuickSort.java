package com.jirlan.algorithms.sort;

public class QuickSort {
    public static int[] sort(int[] list) {
        return sort(list, 0, list.length - 1);
    }

    private static int[] sort(int[] list, int start, int end) {
        var pivot = list[start];
        var left = start;
        var right = end;

        while (left <= right) {
            while (list[left] < pivot) left++;
            while (list[right] > pivot) right--;

            if (left <= right) {
                swap(list, left, right);
                left++;
                right--;
            }
        }

        if (start < right) sort(list, start, right);
        if (left < end) sort(list, left, end);

        return list;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}