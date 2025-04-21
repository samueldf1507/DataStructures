package estruturadedados.exercises.stack.domain;

public class Exercise1 {
    public int[] items;
    public int top;
    public int capacity;

    public Exercise1(int cap) {
        this.items = new int[cap];
        this.top = -1;
        this.capacity = cap;
    }

    public int size() {
        return top + 1;
    }

    public int showTop() {
        return this.items[top];
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == capacity - 1;
    }

    public void printWholeStack() {
        for (int i = 0; i < top + 1; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public void push(int element) {
        if (isFull()) {
            throw new IllegalArgumentException("A pilha está cheia!");
        }

        this.top++;
        this.items[top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("A pilha está vazia!");
        }
        int removeditem = items[top];
        this.top--;
        return removeditem;
    }


}
