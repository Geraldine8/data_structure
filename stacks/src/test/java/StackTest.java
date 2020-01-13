import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackTest {
    Stack<Integer> stack;

    @Before
    public void setup() {
        stack = new Stack<Integer>();
    }

    @Test
    public void testEmptyStack(){
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
    }

    @Test (expected = Exception.class)
    public void testPopOnEmpty(){
        stack.pop();
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        stack.peek();
    }

    @Test
    public void testPush(){
        stack.push(2);
        stack.push(4);
        stack.push(6);
        assertEquals(stack.size(), 3);
    }

    @Test
    public void testPeek() {
        stack.push(2);
        assertTrue(stack.peek() == 2);
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testPop(){
        stack.push(9);
        stack.push(8);
//        assertTrue(stack.peek() == 9);
        assertTrue(stack.peek() == 8);
        assertEquals(stack.size(), 2);
    }

    @Test
    public void testEverything(){
        assertTrue(stack.isEmpty());
        stack.push(5);
        assertTrue(!stack.isEmpty());
        stack.push(20);
        assertEquals(stack.size(), 2);
        assertTrue(stack.peek() == 20);
        assertEquals(stack.size(), 2);
        assertTrue(stack.pop() == 20);
        assertEquals(stack.size(), 1);
        assertTrue(stack.peek() == 5);
        assertEquals(stack.size(), 1);
        assertTrue(stack.pop() == 5);
        assertEquals(stack.size(), 0);
        assertTrue(stack.isEmpty());
    }


}
