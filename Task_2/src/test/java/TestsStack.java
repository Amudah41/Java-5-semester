import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestsStack {
    MyStack<Integer> myTestStack = new MyStack();

    @Test
    public void testIsEmpty() {
        assertEquals(myTestStack.isEmpty(), true);
    }

    @Test
    public void testPush() {
        MyStack<Integer> myTestStack = new MyStack<>();
        myTestStack.push(3);
        int expected = myTestStack.peek();
        assertEquals(expected, 3);
    }

    @Test
    public void testPop() {
        MyStack<Integer> myTestStack = new MyStack<>();
        myTestStack.push(2);
        myTestStack.push(3);
        myTestStack.pop();
        int expected = myTestStack.peek();
        assertEquals(expected, 2);
    }

}
