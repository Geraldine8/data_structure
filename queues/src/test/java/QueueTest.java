import org.junit.Before;
import org.junit.Test;
import sun.invoke.empty.Empty;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class QueueTest {

    Queue<Integer> queue;

    @Before
    public void setup(){
        queue = new Queue<Integer>();
    }

    @Test
    public void testEmptyQueue(){
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

    @Test(expected = Exception.class)
    public void testPollOnEmpty() {
        queue.poll();
    }

    @Test(expected = Exception.class)
    public void testPeekOnEmpty() {
        queue.peek();
    }

    @Test
    public void testOffer(){
        queue.offer(5);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testPeek(){
        queue.offer(9);
        assertTrue(queue.peek() == 9);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void ptetsPoll(){
        queue.offer(2);
        assertTrue(queue.poll() == 2);
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testExhaustively(){
        assertTrue(queue.isEmpty());
        queue.offer(1);
        assertTrue(!queue.isEmpty());
        queue.offer(2);
        assertEquals(queue.size(), 2);
        assertTrue(queue.peek() == 1);
        assertEquals(queue.size(), 2);
        assertTrue(queue.poll() == 1);
        assertEquals(queue.size(), 1);
        assertTrue(queue.peek() == 2);
        assertEquals(queue.size(), 1);
        assertTrue(queue.poll() == 2);
        assertEquals(queue.size(), 0);
        assertTrue(queue.isEmpty());
    }



}
