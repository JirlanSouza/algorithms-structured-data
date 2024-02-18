package com.jirlan.algorithms.sort;

public class BubbleSort {
    public static  int[] sort(int[] list) {

        for (int i = list.length - 1; i > 0; i--) {
            var changes = 0;

            for (int j = 0; j < i; j++) {

                if (list[j] > list[j +1]) {
                    var temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    changes++;
                }
            }
            if (changes < 1) break;
        }

        return list;
    }
}