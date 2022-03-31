package tesco.sort;

import sort.QuickSort;
import sort.Sort;

public class QuickSortTest extends SortTest {
    Sort getSorterClass() {
        return new QuickSort();
    }
}
