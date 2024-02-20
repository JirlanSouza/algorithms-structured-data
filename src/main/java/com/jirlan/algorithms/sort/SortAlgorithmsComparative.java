package com.jirlan.algorithms.sort;

import com.jirlan.common.ExecutionTime;

import java.util.Random;

public class SortAlgorithmsComparative {
    public static void main(String[] args) {

        System.out.println("Ordenação de um Array com 10k números inteiros.");

        int[] dataSet = new Random().ints().limit(10_000L).toArray();
        ExecutionTime.mettle("  Quick sort", dataSet.clone(), QuickSort::sort);
        ExecutionTime.mettle("  Bubble sort", dataSet.clone(), BubbleSort::sort);

        System.out.println("\nOrdenação de um array com 100k números inteiros.");

        dataSet = new Random().ints().limit(100_000L).toArray();
        ExecutionTime.mettle("  Quick sort", dataSet.clone(), QuickSort::sort);
        ExecutionTime.mettle("  Bubble sort", dataSet.clone(), BubbleSort::sort);

    }
}
