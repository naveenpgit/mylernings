package tesco.sort;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import sort.InsertionSort;
import sort.Sort;

@RunWith(JUnit4.class)
public class InsertionSortTest extends SortTest {

    Sort getSorterClass() {
        return new InsertionSort();
    }
}
