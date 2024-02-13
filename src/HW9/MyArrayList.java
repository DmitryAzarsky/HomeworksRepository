package HW9;

import java.util.*;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] data;
    private int size;

    public MyArrayList() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T input) {
        if (data.length == size) {
            T[] tempData = Arrays.copyOf(data, size + size / 2);
            data = tempData;
        }
        data[size] = input;
        size++;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return data[i];
            }
        }
        return data[size];
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] valuesAfterDeletedElement = (T[]) new Object[size - (index + 1)];
        for (int i = 0; i < valuesAfterDeletedElement.length; i++) {
            valuesAfterDeletedElement[i] = data[index + i + 1];
        }
        T[] valuesBeforeDeletedElement = (T[]) new Object[index];
        for (int i = 0; i < valuesBeforeDeletedElement.length; i++) {
            valuesBeforeDeletedElement[i] = data[i];
        }
        T[] allValuesExceptDeletedElement = (T[]) new Object[data.length];
        for (int i = 0; i < valuesAfterDeletedElement.length + valuesBeforeDeletedElement.length; i++) {
            if (i < valuesBeforeDeletedElement.length) {
                allValuesExceptDeletedElement[i] = valuesBeforeDeletedElement[i];
            } else if (i >= valuesBeforeDeletedElement.length) {
                allValuesExceptDeletedElement[i] = valuesAfterDeletedElement[i - index];
            }
        }
        data = allValuesExceptDeletedElement;
        size--;
    }
    public int size(){
        return this.size;
    }
    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

}
