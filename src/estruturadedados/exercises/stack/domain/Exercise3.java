package estruturadedados.exercises.stack.domain;

public class Exercise3 {
    private int[] items;
    private int top;
    private int capacity;

    public Exercise3(int cap) {
        this.items = new int[cap];
        this.top = -1;
        this.capacity = cap;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int showTop() {
        return items[top];
    }

    public void push(int number) {
        if (isFull()) {
            throw new IllegalArgumentException("A pilha está cheia!");
        }

        this.top++;
        this.items[top] = number;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Pilha está vazia!");
        }
        int removedItem = items[top];
        this.top--;
        return removedItem;

    }

    public void printStack() {
        for (int i = 0; i < top + 1; i++) {
            System.out.print(items[i] + " ");
        }
    }
}
