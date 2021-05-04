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
public interface Queue<E> {

    void enqueue(E elem);

    E dequeue();

    E peek();

    int size();

    boolean isEmpty();

    String toString();

}
