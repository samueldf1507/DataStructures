package estruturadedados.exercises.stack.domain;

public class Exercise2 {
    private char[] items;
    private int top;
    private int capacity;

    public Exercise2(int cap) {
        this.items = new char[cap];
        this.top = -1;
        this.capacity = cap;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(char element) {
        if (isFull()) {
            throw new IllegalArgumentException("A pilha está cheia!");
        }

        this.top++;
        this.items[top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("A lista está vazia!");
        }
        int removedItem = items[top];
        this.top--;
        return removedItem;
    }
}
