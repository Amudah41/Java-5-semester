import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<E> implements List<E> {
    private Object[] array;
    private int size;
    private int capacity;
    private final int CAPACITY_INCREASE = 2;
    private final int START_CAPACITY = 8;
    private final int MAX_CAPACITY = Integer.MAX_VALUE;

    public MyArrayList() {
        this.array = new Object[START_CAPACITY];
        this.capacity = START_CAPACITY;
        this.size = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.array = new Object[capacity];
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Массив пуст");
        }
    }

    @Override
    public boolean add(E data) {
        if (this.size == this.capacity) {
            increaseCapacity();
        }
        this.array[this.size] = data;
        this.size++;
        return true;
    }

    private void increaseCapacity() {
        if (this.capacity == MAX_CAPACITY) {
            throw new IndexOutOfBoundsException("Превышение вместимости массива");
        }
        int newCapacity;
        if (this.capacity <= MAX_CAPACITY / CAPACITY_INCREASE) {
            newCapacity = this.capacity * CAPACITY_INCREASE;
        } else {
            newCapacity = MAX_CAPACITY;
        }
        Object[] tmp = new Object[newCapacity];
        System.arraycopy(this.array, 0, tmp, 0, this.capacity);
        this.array = tmp;
        this.capacity = newCapacity;
    }

    public void addWithIndex(int index, E elem) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательным");
        }
        if (index > this.size) {
            throw new IllegalArgumentException("Выход за границы");
        }
        if (this.size == this.capacity) {
            increaseCapacity();
        }
        System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        this.array[index] = elem;
        this.size++;
    }


    public E remove(int index) {
        Object tmp = this.array[index];
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("Массив пуст");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательным");
        }
        if (this.size - index > 0) {
            System.arraycopy(this.array, index + 1, this.array, index, this.size - index);
        } else {
            throw new IllegalArgumentException("Выход за границу массива");
        }
        this.array[--size] = null;
        return (E) tmp;

    }

    @Override
    public boolean contains(Object data) {
        for (int i = 0; i <= this.size; i++) {
            if (data.equals(this.array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        return (E) this.array[index];
    }


    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(this.array[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public List<E> subList(int i, int i1) {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public Stream<E> stream() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }

    @Override
    public Stream<E> parallelStream() {
        throw new UnsupportedOperationException("Эта операция не поддерживается");
    }
}