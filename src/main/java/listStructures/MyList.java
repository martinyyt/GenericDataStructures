package listStructures;

import java.util.*;

/**
 * Represents a generic list data structure.
 *
 * @param <T>
 */
public class MyList<T> implements MyStack<T>, MyQueue<T>, IMyList<T> {

    private static final int INITIAL_CAPACITY = 16;
    private Object[] elements; // This cannot be T[], because it cannot be instantiated later
    private int length = 0;

    /**
     * Constructs an empty list.
     */
    public MyList() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.length = 0;
    }

    /**
     * Checks if the given index is within the length of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Checks if the given index is within the length of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Gets the length of the list.
     *
     * @return the length of the list
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Inserts an element at exact index.
     *
     * @param index   the index where the new element is added
     * @param element the element to addLast
     */
    public void addAt(int index, T element) {
        this.rangeCheckForAdd(index);
        Object[] extendedElements = this.elements;
        if (this.length == this.elements.length) { // makes new array with double size
            extendedElements = new Object[this.elements.length * 2];
        }
        System.arraycopy(elements, 0, extendedElements, 0, length);
        System.arraycopy(elements, index, extendedElements, index + 1, length - index);
        this.length++;
        extendedElements[index] = element;

        elements = extendedElements;
    }

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to addLast
     */
    public void addLast(T element) {
        this.addAt(length, element);
    }

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to addLast
     */
    public void addFirst(T element) {
        this.addAt(0, element);
    }

    /**
     * Removes the element at given index.
     *
     * @param index the index of the element to be removed
     */
    public void delete(int index) {
        this.rangeCheck(index);
        //Object element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, length - index - 1);
        this.length--;
    }

    /**
     * Takes and removes the last element.
     *
     * @return the last element
     * @throws NoSuchElementException
     */
    public T popLast() {
        if (this.length == 0) {
            throw new NoSuchElementException();
        }
        T lastElement = this.getLast();
        this.delete(this.length - 1);
        return lastElement;
    }

    /**
     * Takes and removes the first element.
     *
     * @return the first element
     * @throws NoSuchElementException
     */
    public T popFirst() {
        if (this.length == 0) {
            throw new NoSuchElementException();
        }
        T firstElement = this.getFirst();
        this.delete(0);
        return firstElement;
    }


    /**
     * Gets the element by its index.
     *
     * @param index the index of the element
     * @return the element at the given index
     */
    public T get(int index) {
        this.rangeCheck(index);
        return (T) elements[index];
    }

    /**
     * Gets the last element without removing.
     *
     * @return the last element
     * @throws NoSuchElementException
     */
    public T getLast() {
        if (this.length == 0) {
            throw new NoSuchElementException();
        }
        return this.get(this.length - 1);
    }

    /**
     * Gets the first element without removing.
     *
     * @return the first element
     * @throws NoSuchElementException
     */
    public T getFirst() {
        if (this.length == 0) {
            throw new NoSuchElementException();
        }
        return this.get(0);
    }

    /**
     * Searches for element in the list.
     *
     * @param element the element to search for
     * @return the index where element is found first; -1 if the element is not found
     */
    public int indexOf(T element) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks if this element is present in the list.
     * @param element the element to search for
     * @return true if element is present
     */
    public boolean contains(T element) {
        return this.indexOf(element) != -1;
    }

    /**
     * Clears the list.
     */
    public void clear() {
        for (Object element : this.elements) {
            element = null;
        }
        length = 0;
    }

    /**
     * Sorts ascending the list.
     */
    public void sort() {
        Arrays.sort((T[]) elements, 0, length);
    }

    @Override
    public String toString() {
        if (this.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            sb.append(this.elements[i]);
            if (i != this.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }
}
