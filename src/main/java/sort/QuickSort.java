package sort;

public class QuickSort implements Sort {


    @Override
    public int[] sort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }


    private int[] quickSort(int[] arr, int start, int end) {
        //int pIndex = findPIndex();
        return null;

    }

    public static void main(String[] args) {

        int[] array = new int[]{7, 2, 1, 6, 8, 5, 3, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);

    }
}
