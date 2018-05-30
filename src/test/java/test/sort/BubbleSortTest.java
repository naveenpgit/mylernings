package test.sort;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import sort.BubbleSort;
import sort.Sort;

@RunWith(JUnit4.class)
public class BubbleSortTest extends SortTest {

    Sort getSorterClass() {
        return new BubbleSort();
    }

}
