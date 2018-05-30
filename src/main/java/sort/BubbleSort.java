package sort;

public class BubbleSort implements Sort {

    public int[] sort(int[] arr) {
        int itera = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            boolean swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                itera++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                //break;
            }
        }
        System.out.println("BubbleSort Iterations ===> " + itera);
        return arr;
    }
}
