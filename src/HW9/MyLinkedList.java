package HW9;
import java.util.*;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
    }
    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }
    public void remove(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0){
            head = current.next;
            head.previous = null;
        } else if (index == size-1) {
            tail = current.previous;
            tail.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> previous;
        public Node(T value) {
            this.value = value;
        }
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}
