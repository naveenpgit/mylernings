package sort;

public class RecursiveBubbleSort implements Sort {

    int itera;

    public int[] sort(int[] arr) {
        itera = 0;
        int[] sorted = bubbleSort(arr, arr.length);
        System.out.println("RecursiveBubbleSort Iterations ===> " + itera);
        return sorted;
    }

    private int[] bubbleSort(int[] arr, int n) {

        if (n == 1) {
            return arr;
        }
        for (int i = 0; i < n - 1; i++) {
            itera++;
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        return bubbleSort(arr, n - 1);
    }
}
