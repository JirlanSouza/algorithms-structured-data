public class BubbleSort {
    public static void main(String[] args) {
        int[] unsortedData = new int[20];

        for (int i = 0; i < unsortedData.length; i++) {
            unsortedData[i] = (int) Math.round(Math.random() * 1000);
            System.out.print(unsortedData[i] + ", ");
        }

        System.out.println();
        int[] sortedData = BubbleSort.optimizedSort(unsortedData, false);

        for (int data : sortedData) {
            System.out.print(data + ", ");
        }

        System.out.println();
    }

    /*
     * Complexidade assintótica
     * Pior caso: O(n²)
     * Melhor caso: Ω(n²)
     */

    public static int[] sort(int[] data, boolean desc) {
        int swap;
        for (int i = 1; i < data.length; i++) {

            for (int j = 0; j < data.length - 1; j++) {
                if ((data[j] > data[j + 1] && !desc) || (data[j] < data[j + 1] && desc)) {
                    swap = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = swap;
                }
            }
        }

        return data;
    }

    /*
     * Complexidade assintótica
     * Pior caso: O(n²)
     * Melhor caso: Ω(n)
     */

    public static int[] optimizedSort(int[] data, boolean desc) {
        boolean swaping = true;
        int swap;
        int iterator = 0;

        while (iterator <= data.length && swaping) {
            iterator++;
            swaping = false;

            for (int j = 0; j < data.length - 1; j++) {
                if ((data[j] > data[j + 1] && !desc) || (data[j] < data[j + 1] && desc)) {
                    swaping = true;
                    swap = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = swap;
                }
            }
        }

        return data;
    }
}