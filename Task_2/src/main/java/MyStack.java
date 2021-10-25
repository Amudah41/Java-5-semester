
class MyStack<E> extends MyArrayList<E> {
    private int top;
    private MyArrayList<E> array;

    public MyStack() {
        array = new MyArrayList<E>();
        top = 0;
    }

    public void push(E data) {
        this.array.add(data);
        top++;
    }

    public E pop() {
        if (!this.array.isEmpty()) {
            int index = top - 1;
            top--;
            return this.array.remove(index);
        } else {
            throw new IllegalArgumentException("Стек пуст");
        }
    }

    public E peek() {
        if (!this.array.isEmpty()) {
            return this.array.get(top - 1);
        } else {
            throw new IllegalArgumentException("Стек пуст");
        }
    }

    public void printStack() {
        for (int i = 0; i < this.top; i++) {
            System.out.print(this.array.get(i) + " ");
        }
        System.out.println();
    }

}