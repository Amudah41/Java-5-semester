
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integerList = new MyArrayList<>();
        integerList.isEmpty();
        integerList.addWithIndex(0, 42);
        integerList.addWithIndex(1, 43);
        integerList.addWithIndex(2, 4);
        System.out.println(integerList.toString());
        System.out.println();

        integerList.remove(0);
        System.out.println(integerList.toString());

        System.out.println(integerList.isEmpty());

        integerList.add(2);
        integerList.add(7);
        System.out.println(integerList.toString());

        System.out.println();
        integerList.addWithIndex(2, 0);
        integerList.get(2);
        System.out.println(integerList.get(2));
        System.out.println(integerList.contains(7));
        System.out.println(integerList.isEmpty());
        System.out.println(integerList.toString());

        MyStack<Integer> integerStack = new MyStack();

        integerStack.push(77);
        integerStack.push(78);
        integerStack.push(79);

        integerStack.printStack();

        integerStack.pop();
        integerStack.printStack();
        System.out.println(integerStack.peek());
    }
}