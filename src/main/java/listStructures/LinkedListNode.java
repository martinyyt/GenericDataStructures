package listStructures;

import java.util.LinkedList;
import java.util.List;

public class LinkedListNode<T extends Comparable<T>> {
    private T value;
    private LinkedListNode<T> previous;
    private LinkedListNode<T> next;

    public LinkedListNode(LinkedListNode<T> previous, T element, LinkedListNode<T> next){
        this.previous=previous;
        this.value=element;
        this.next=next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode<T> previous) {
        this.previous = previous;
    }

    public LinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<T> next) {
        this.next = next;
    }
}
