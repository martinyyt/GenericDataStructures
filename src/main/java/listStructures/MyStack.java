package listStructures;

/**
 * Represents a LIFO list structure (last in first out)
 * @param <T>
 */
public interface MyStack<T> {
    /**
     * Adds element at the end.
     *
     * @param element
     */
    public void addLast(T element);

    /**
     * Takes the last element and removes it.
     *
     * @return
     */
    public T popLast();

    /**
     * Gets the last element without removing it.
     *
     * @return
     */
    public T getLast();

    /**
     * Gets the length.
     *
     * @return
     */
    public int getLength();

    /**
     * Clears all data.
     */
    public void clear();

    /**
     * Checks if element is present.
     *
     * @param element
     * @return true if found
     */
    public boolean contains(T element);
}
