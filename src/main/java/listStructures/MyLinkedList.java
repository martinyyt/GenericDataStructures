package listStructures;

import java.util.*;

public class MyLinkedList<T extends Comparable<T>> implements MyQueue<T>, MyStack<T>, IMyList<T> {
    private int length = 0;
    private LinkedListNode<T> first;
    private LinkedListNode<T> last;

    public MyLinkedList() {
        this.length = 0;
        this.first = null;
        this.last = null;
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
     * Gets a node from the list by its index.
     * @param index the index of the node
     * @return the node at the given index
     */
    private LinkedListNode<T> getNode(int index) {
        this.rangeCheck(index);

        if (this.length > 2 * index) {
            LinkedListNode<T> current = this.first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current;
        } else {
            LinkedListNode<T> current = this.last;
            for (int i = this.length - 1; i > index; i--) {
                current = current.getPrevious();
            }
            return current;
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
        if (index == this.length) {
            this.addLast(element);
            return; // or maybe just make else statement
        }
        LinkedListNode<T> oldElement = this.getNode(index);
        LinkedListNode<T> newElement = new LinkedListNode<>(oldElement.getPrevious(), element, oldElement);
        oldElement.setPrevious(newElement);
        newElement.getPrevious().setNext(newElement);
        length++;
    }

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to addLast
     */
    public void addFirst(T element) {
        LinkedListNode<T> oldFirst = this.first;
        LinkedListNode<T> newElement = new LinkedListNode<>(null, element, oldFirst);
        this.first = newElement;
        if (oldFirst == null) {
            this.last = newElement;
        } else {
            oldFirst.setPrevious(newElement);
        }
        length++;
    }

    /**
     * Adds new element at the end of the list.
     *
     * @param element the element to addLast
     */
    public void addLast(T element) {
        LinkedListNode<T> oldLast = this.last;
        LinkedListNode<T> newElement = new LinkedListNode<>(oldLast, element, null);
        this.last = newElement;
        if (oldLast == null) {
            this.first = newElement;
        } else {
            oldLast.setNext(newElement);
        }
        length++;
    }

    /**
     * Removes the element at given index.
     *
     * @param index the index of the element to be removed
     */
    public void delete(int index) {
        this.rangeCheck(index);
        LinkedListNode<T> nodeToDelete = this.getNode(index);

        if (nodeToDelete.getPrevious() == null) {
            this.first = nodeToDelete.getNext();
        } else {
            nodeToDelete.getPrevious().setNext(nodeToDelete.getNext()); // the previous node is linked to the next
            nodeToDelete.setPrevious(null);
        }

        if (nodeToDelete.getNext() == null) {
            this.last = nodeToDelete.getPrevious();
        } else {
            nodeToDelete.getNext().setPrevious(nodeToDelete.getPrevious()); // the next node is linked to the previous
            nodeToDelete.setNext(null);
        }

        nodeToDelete.setValue(null);
        length--;
    }

    /**
     * Takes and removes the last element.
     *
     * @return the last element
     * @throws NoSuchElementException
     */
    public T popLast() {
        T lastValue = this.getLast();
        this.delete(this.length - 1);
        return lastValue;
    }

    /**
     * Takes and removes the first element.
     *
     * @return the first element
     * @throws NoSuchElementException
     */
    public T popFirst() {
        T firstValue = this.getFirst();
        this.delete(0);
        return firstValue;
    }

    /**
     * Gets the element by its index.
     *
     * @param index the index of the element
     * @return the element at the given index
     */
    public T get(int index) {
        return this.getNode(index).getValue();
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
        return this.last.getValue();
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
        return this.first.getValue();
    }

    /**
     * Searches for element in the list.
     *
     * @param element the element to search for
     * @return the index where element is found first; -1 if the element is not found
     */
    public int indexOf(T element) {
        int index = 0;
        for (LinkedListNode<T> x = this.first; x != null; x = x.getNext()) {
            if (element.equals(x.getValue())) {
                return index;
            }
            index++;
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
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    /**
     * Sorts ascending the list, by insertion sort algorithm.
     */
    public void sort() {
        LinkedListNode<T> current = this.first;
        LinkedListNode<T> next = this.first;
        for (int i = 0; i < this.length; i++) {
            if (i != 0) {
                current = next;
            }
            next = next.getNext();
            while (current.getPrevious() != null && current.getValue().compareTo(current.getPrevious().getValue()) < 0) {
                // no need to swap nodes, just swap the values of current and previous
                T temp = current.getValue();
                current.setValue(current.getPrevious().getValue());
                current.getPrevious().setValue(temp);
                current = current.getPrevious();
            }
        }
    }

    @Override
    public String toString() {
        if (this.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        LinkedListNode<T> current = this.first;
        for (int i = 0; i < this.length; i++) {
            sb.append(current.getValue());
            if (i != this.length - 1) {
                sb.append(" | ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}