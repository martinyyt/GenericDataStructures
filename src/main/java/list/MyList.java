package list;

import java.util.*;

/**
 * Represents a generic list data structure.
 *
 * @param <T>
 */
public class MyList<T> {

    private static final int INITIAL_CAPACITY = 16;
    private Object[] elements; // This cannot be T[], because it cannot be instantiated later
    private int count;

    /**
     * Constructs an empty list.
     */
    public MyList() {
        this.elements = new Object[INITIAL_CAPACITY];
        count = 0;
    }

    /**
     * Checks if the given index is within the length of the list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Gets the length of the list.
     *
     * @return the length of the list
     */
    public int getLength() {
        return this.count;
    }

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to add
     */
    public void add(T element) {
        Object[] extendedElements = this.elements;
        if (this.count == this.elements.length) { // makes new array with double size
            extendedElements = new Object[this.elements.length * 2];
        }
        System.arraycopy(elements, 0, extendedElements, 0, count);
        extendedElements[count] = element;
        this.count++;
        elements = extendedElements;
    }

    /**
     * Inserts an element at exact index.
     *
     * @param index   the index where the new element is added
     * @param element the element to add
     */
    public void addAt(int index, T element) {
        this.rangeCheck(index);
        Object[] extendedElements = this.elements;
        if (this.count == this.elements.length) { // makes new array with double size
            extendedElements = new Object[this.elements.length * 2];
        }
        System.arraycopy(elements, 0, extendedElements, 0, count);
        System.arraycopy(elements, index, extendedElements, index + 1, count - index);
        this.count++;
        extendedElements[index] = element;

        elements = extendedElements;
    }

    /**
     * Removes the element at given index.
     *
     * @param index the index of the element to be removed
     */
    public void delete(int index) {
        this.rangeCheck(index);
        Object element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, count - index - 1);
        this.count--;
    }

    /**
     * Gets the element by its index.
     *
     * @param index the index of the element
     * @return the element at the given index
     */
    public Object get(int index) {
        this.rangeCheck(index);
        return elements[index];
    }

    /**
     * Searches for element in the list.
     *
     * @param element the element to search for
     * @return the index where element is found first; -1 if the element is not found
     */
    public int find(T element) {
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Sorts ascending the list
     */
    public void sort() {
        Arrays.sort((T[]) elements, 0, count);
    }
}
