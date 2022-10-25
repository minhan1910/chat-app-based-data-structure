package model;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node() {
        this.value = null;
        this.next = null;
        this.prev = null;
    }

    public Node(T value) {
        this();
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this(value);
        this.next = next;
    }

    public Node(T value, Node<T> prev, Node<T> next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return value;
    }

    public void setData(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
