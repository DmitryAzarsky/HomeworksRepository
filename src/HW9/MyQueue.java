package HW9;

public class MyQueue<T> {
    private Node<T> firstElement;
    private Node<T> lastElement;
    private int size;

    public void add(T element) {
        Node<T> node = new Node<>(element);
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
    public T peek() {
        return firstElement.value;
    }
    public T poll(){
        T valueToReturn = firstElement.value;
        if (size==1) {
            firstElement = null;
            lastElement = null;
            size--;
            return valueToReturn;
        }
        firstElement = firstElement.next;
        firstElement.previous = null;
        size--;
        return valueToReturn;
    }
    public void clear(){
        firstElement = null;
        lastElement = null;
        size = 0;
    }
    public int size() {
        return this.size;
    }

    private static class Node<T> {
        T value;
        MyQueue.Node<T> next;
        MyQueue.Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }
}
