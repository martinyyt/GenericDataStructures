package listStructures;

/**
 * Represents a FIFO list structure (firs in first out)
 * @param <T>
 */
public interface MyQueue<T> {
    /**
     * Adds element at the end.
     *
     * @param element
     */
    public void addLast(T element);

    /**
     * Takes the first element and removes it.
     *
     * @return
     */
    public T popFirst();

    /**
     * Gets the first element without removing it.
     *
     * @return
     */
    public T getFirst();

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
