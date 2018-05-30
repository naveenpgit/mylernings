package test.sort;

import sort.RecursiveBubbleSort;
import sort.Sort;

public class RecursiveBubbleSortTest extends SortTest {

    Sort getSorterClass() {
        return new RecursiveBubbleSort();
    }
}
