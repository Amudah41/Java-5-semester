import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestsList {

    MyArrayList<Integer> myTestList = new MyArrayList<>();

   @Before
    public void setUp() {
        myTestList.add(2);
        myTestList.add(7);
        myTestList.add(1);
    }

    @Test
    public void testSize1() {
        assertEquals(3, myTestList.size());
    }
    @Test
    public void testIsEmpty1() {
        assertEquals(myTestList.isEmpty(), false);
    }


    @Test
    public void testIsContains() {
        assertEquals(myTestList.isContains(4), false);
        assertEquals(myTestList.isContains(2), true);
    }

    @Test
    public void testGet() {
        MyArrayList<Integer> myTestList2 = new MyArrayList<>();
        myTestList2.addWithIndex(0, 42);
        myTestList2.addWithIndex(1, 3);
        myTestList2.addWithIndex(2, 4);
        int expected = myTestList2.get(2);
        assertEquals(expected, 4);
    }

    @Test
    public void testRemove() {
        MyArrayList<Integer> myTestList3 = new MyArrayList<>();
        myTestList3.addWithIndex(0, 11);
        myTestList3.addWithIndex(1, 3);
        myTestList3.addWithIndex(2, 4);
        myTestList3.remove(1);
        int expected = myTestList3.get(1);
        assertEquals(expected, 4);
        assertEquals(myTestList3.size(), 2);

    }

    MyArrayList<Integer> myTestList4 = new MyArrayList<>();

    @Test
    public void testIsEmpty2() {
        assertEquals(myTestList4.isEmpty(), true);
    }

    @Test
    public void testSize2() {
        assertEquals(0, myTestList4.size());
    }
}
