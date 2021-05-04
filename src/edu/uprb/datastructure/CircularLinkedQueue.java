/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.datastructure;

/**
 *
 *
 * @author Luis J. Berríos Negrón
 */
public class CircularLinkedQueue<E> implements Queue<E> {

    private Node<E> rear;
    private int size;

    public CircularLinkedQueue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException(
                    "invalid capacity: " + initialCapacity);
        }

        rear = null;
        size = 0;
    }

    public CircularLinkedQueue() {
        this(10);
    }

    @Override
    public void enqueue(E elem) {
        Node<E> temp = new Node<>(elem, null);
        if (isEmpty()) {
            rear = temp;
            rear.next = rear;
        } else {
            temp.next = rear.next;
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    @Override
    public E dequeue() {
        checkNotEmpty();
        E elem = rear.next.data;
        if (rear == rear.next) {
            rear = null;
        } else {
            rear.next = rear.next.next;
        }
        size--;
        return elem;
    }

    @Override
    public E peek() {
        checkNotEmpty();
        return rear.next.data;
    }

    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> trav = rear;
        for(int i = 1; i <= size; i++) {
            trav = trav.next;
            builder.append(trav.data);
            if (i != size) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
