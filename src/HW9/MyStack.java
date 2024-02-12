package HW9;

import java.util.Objects;

public class MyStack<T> {
    private MyStack.Node<T> firstElement;
    private MyStack.Node<T> lastElement;
    private int size;
    private static class Node<T> {
        T value;
        MyStack.Node<T> next;
        MyStack.Node<T> previous;
        public Node(T value) {
            this.value = value;
        }
    }
    public void remove(int index) {
        Objects.checkIndex(index, size);
        MyStack.Node<T> current = firstElement;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (size == 1) {
            firstElement = null;
            lastElement = null;
        } else if (index == 0){
            firstElement = current.next;
            lastElement.previous = null;
        } else if (index == size-1) {
            firstElement = current.previous;
            lastElement.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
    }
    public void push(T element) {
        MyStack.Node<T> node = new MyStack.Node<>(element);
        if (firstElement == null) {
            firstElement = node;
            lastElement = node;
        } else {
            node.previous = lastElement;
            lastElement.next = node;
            lastElement = node;
        }
        size++;
    }
    public int size() {
        return size;
    }
    public T peek() {
        return lastElement.value;
    }
    public void clear(){
        firstElement = null;
        lastElement = null;
        size = 0;
    }
    public T pop(){
        T valueToReturn = lastElement.value;
        if (size==1) {
            firstElement = null;
            lastElement = null;
            size--;
            return valueToReturn;
        }
        lastElement = lastElement.previous;
        lastElement.next = null;
        size--;
        return valueToReturn;
    }
}
