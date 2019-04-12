package listStructures;

import java.util.NoSuchElementException;

public interface IMyList<T> {
    /**
     * Gets the length of the list.
     *
     * @return the length of the list
     */
    public int getLength();

    /**
     * Inserts an element at exact index.
     *
     * @param index   the index where the new element is added
     * @param element the element to addLast
     */
    public void addAt(int index, T element);

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to addLast
     */
    public void addLast(T element);

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to addLast
     */
    public void addFirst(T element);

    /**
     * Removes the element at given index.
     *
     * @param index the index of the element to be removed
     */
    public void delete(int index);

    /**
     * Takes and removes the last element.
     *
     * @return the last element
     * @throws NoSuchElementException
     */
    public T popLast();

    /**
     * Takes and removes the first element.
     *
     * @return the first element
     * @throws NoSuchElementException
     */
    public T popFirst();

    /**
     * Gets the element by its index.
     *
     * @param index the index of the element
     * @return the element at the given index
     */
    public T get(int index);

    /**
     * Gets the last element without removing.
     *
     * @return the last element
     * @throws NoSuchElementException
     */
    public T getLast();

    /**
     * Gets the first element without removing.
     *
     * @return the first element
     * @throws NoSuchElementException
     */
    public T getFirst();

    /**
     * Searches for element in the list.
     *
     * @param element the element to search for
     * @return the index where element is found first; -1 if the element is not found
     */
    public int indexOf(T element);

    public boolean contains(T element);

    public void clear();

    /**
     * Sorts ascending the list
     */
    public void sort();
}
