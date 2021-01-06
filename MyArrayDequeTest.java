import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class MyArrayDequeTest {

    @Test
    public void testAddFirst() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        arr.addFirst("d");
        arr.addFirst("c");
        arr.addFirst("b");
        arr.addFirst("a");
        String actual0 = arr.removeFirst();
        String expected0 = "a";
        String actual1 = arr.removeLast();
        String expected1 = "d";
        String actual2 = arr.removeFirst();
        String expected2 = "b";
        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    @Test
    public void testaddLast() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        arr.addLast("a");
        arr.addLast("b");
        arr.addLast("c");
        String actual0 = arr.removeFirst();
        String expected0 = "a";
        assertEquals(expected0, actual0);
        String actual1 = arr.removeLast();
        String expected1 = "c";
        assertEquals(expected1, actual1);
        String actual2 = arr.removeFirst();
        String expected2 = "b";
        assertEquals(expected2, actual2);
    }

    @Test
    public void testremoveFirst() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        String actual0 = arr.removeFirst();
        String expected0 = null;
        assertEquals(expected0, actual0);
        arr.addFirst("o");
        arr.addLast("r");
        arr.addFirst("T");
        arr.addLast("i");
        String actual1 = arr.removeFirst();
        String expected1 = "T";
        assertEquals(expected1, actual1);
        String actual2 = arr.removeFirst();
        String expected2 = "o";
        assertEquals(expected2, actual2);
    }
    @Test
    public void testremoveLast() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        arr.addFirst("o");
        arr.addLast("r");
        arr.addFirst("T");
        arr.addLast("i");
        String actual0 = arr.removeLast();
        String expected0 = "i";
        assertEquals(expected0, actual0);
        String actual1 = arr.removeLast();
        String expected1 = "r";
        assertEquals(expected1, actual1);
        String actual2 = arr.removeLast();
        String expected2 = "o";
        assertEquals(expected2, actual2);
    }

    @Test
    public void testDeepCopy() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        arr.addFirst("o");
        arr.addLast("r");
        arr.addFirst("T");
        arr.addLast("i");
        ArrayDeque<String> copy = new ArrayDeque<String>(arr);
        assertEquals(arr.size(), copy.size());
        assertEquals(arr.removeFirst(), copy.removeFirst());
        assertEquals(arr.removeLast(), copy.removeLast());
    }

    @Test
    public void testGet() {
        ArrayDeque<String> arr = new ArrayDeque<String>();
        arr.addLast("a");
        arr.addLast("b");
        arr.addLast("c");
        String actual0 = arr.get(0);
        String expected0 = "a";
        String actual1 = arr.get(2);
        String expected1 = "c";
        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
    }

    /**
     * @source https://www.geeksforgeeks.org/generating-random-numbers-in-java/
     * Used source to learn how to generate random numbers.
     */
    @Test
    public void testResize() {
        Random rand = new Random();
        ArrayDeque arr = new ArrayDeque();
        int i = 0;
        while (i < 150) {
            arr.addFirst(rand.nextInt(50));
            i += 1;
        }
        int expected0 = (int) arr.get(0);
        int actual0 = (int) arr.removeFirst();
        int expected1 = (int) arr.get(arr.size() - 1);
        int actual1 = (int) arr.removeLast();
        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
    }

    @Test
    public void testGetExtreme() {
        ArrayDeque arr = new ArrayDeque();
        arr.addLast(0);
        arr.addFirst(1);
        int actual0 =  (int) arr.get(0);
        int expected0 = 1;
        arr.addFirst(3);
        arr.addFirst(4);
        arr.addLast(5);
        arr.addFirst(6);
        arr.addLast(7);
        int actual1 = (int) arr.removeFirst();
        int expected1 = 6;
        int actual2 = (int) arr.get(1);
        int expected2 = 3;
        int actual3 = (int) arr.removeLast();
        int expected3 = 7;
        int actual4 = (int) arr.removeLast();
        int expected4 = 5;
        arr.addLast(12);
        int actual5 = (int) arr.removeFirst();
        int expected5 = 4;
        int actual6 = (int) arr.get(3);
        int expected6 = 12;
        arr.addLast(15);
        int actual7 = (int) arr.removeFirst();
        int expected7 = 3;
        arr.addLast(17);
        arr.addLast(18);
        int actual8 = (int) arr.removeLast();
        int expected8 = 18;
        int actual9 = (int) arr.get(4);
        int expected9 = 17;
        assertEquals(expected0, actual0);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);
        assertEquals(expected7, actual7);
        assertEquals(expected8, actual8);
        assertEquals(expected9, actual9);
    }
}
