/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.test;

import edu.uprb.datastructure.CircularLinkedQueue;
import edu.uprb.datastructure.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test case for the {@link CircularLinkedQueue} class.
 *
 * @author Antonio F. Huertas {@literal <antonio.huertas@upr.edu>}
 * @author Luis J. Berríos Negrón
 */
public class CircularLinkedQueueTest {

    /**
     * Reference to class under test
     */
    Queue<Character> q;

    /**
     * Creates a non-empty queue for testing.
     */
    @BeforeEach
    public void setUp() {
        q = new CircularLinkedQueue<>();

        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
    }

    /**
     * Tests that the queue cannot be assigned an invalid initial capacity.
     */
    @Test
    public void testConstructQueueWithInvalidCapacity() {
        try {
            new CircularLinkedQueue<>(-3);
            fail("Test failure for invalid queue capacity: -3");
        } catch (IllegalArgumentException ex) {
            assertEquals("invalid capacity: -3", ex.getMessage());
        }
    }

    /**
     * Tests that a non-empty queue has the expected string representation.
     */
    @Test
    public void testToStringForNonEmptyQueue() {
        assertEquals("[a, b, c]", q.toString());
    }

    /**
     * Tests that a non-empty queue has the expected size.
     */
    @Test
    public void testSizeForNonEmptyQueue() {
        assertEquals(3, q.size());
    }

    /**
     * Tests that a non-empty queue has the expected status.
     */
    @Test
    public void testIsEmptyForNonEmptyQueue() {
        assertFalse(q.isEmpty());
    }

    /**
     * Tests that a non-empty queue has the expected top element.
     */
    @Test
    public void testPeekForNonEmptyQueue() {
        char ch = q.peek();
        assertEquals('a', ch);
        assertEquals("[a, b, c]", q.toString());
        assertEquals(3, q.size());
    }

    /**
     * Tests that an element can be removed from a non-empty queue.
     */
    @Test
    public void testDequeueForNonEmptyQueue() {
        char ch = q.dequeue();
        assertEquals('a', ch);
        assertEquals("[b, c]", q.toString());
        assertEquals(2, q.size());
    }

}