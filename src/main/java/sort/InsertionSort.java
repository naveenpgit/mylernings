package sort;
//https://www.geeksforgeeks.org/insertion-sort/

public class InsertionSort implements Sort {
    static int itera;

    public int[] sort(int arr[]) {
        itera = 0;
        InsertionSort insertionSort = new InsertionSort();
        for (int i = 1; i < arr.length; i++) {
            ++itera;
            insertionSort.insert(arr, i);
        }

        System.out.println("InsertionSort Iterations ===> " + itera);
        return arr;
    }

    private void insert(int arr[], int i) {
        // Your code here
        int x = arr[i], j;
        for (j = i - 1; j >= 0; j--) {
            ++itera;
            if (arr[j] > x)
                arr[j + 1] = arr[j];
            else
                break;
        }
        arr[j + 1] = x;
    }
}
