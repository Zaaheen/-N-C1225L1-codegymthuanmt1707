package ss10_DSA_arraylist;

import java.util.Arrays;

public class MyList<E> implements Cloneable {
    private Integer size = 0;
    private static final Integer DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    private void ensureCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    public int size() {
        return this.size;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }

        E data = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;

        return data;
    }
    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }

        elements[size] = element;

        size++;

        return true;
    }
    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }

        if (size == elements.length) {
            ensureCapacity();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;

        size++;
    }
    @Override
    public MyList<E> clone() {
        try {
            MyList<E> v = (MyList<E>) super.clone();

            v.elements = java.util.Arrays.copyOf(elements, size);

            v.size = this.size;

            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
