package test.sort;

import org.junit.Before;
import org.junit.Test;
import sort.Sort;

import static org.junit.Assert.assertArrayEquals;

public abstract class SortTest {


    Sort sort;

    @Before
    public void setUp() {
        sort = getSorterClass();
    }

    abstract Sort getSorterClass();

    @Test
    public final void testSort() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, sort.sort(new int[]{5, 2, 4, 6, 1, 3}));
        //assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, sort.sort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        //assertArrayEquals(new int[]{1, 2, 4, 5, 8}, sort.sort(new int[]{5, 1, 4, 2, 8}));
    }
}
