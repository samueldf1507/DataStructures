package estruturadedados.structures.domain;

public class StaticStack {
    private char[] items;
    private int capacity;
    private int top;

    public StaticStack(int cap) {
        this.items = new char[cap];
        this.capacity = cap;
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int StaticStackSize() {
        return top + 1;
    }

    public void push(char item) {
        if (isFull()) {
            System.out.println("A pilha está cheia!");
        }
        this.top++;
        items[top] = item;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
        }
        char removedItem = items[top];
        this.top--;
        return removedItem;
    }

    public char top() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
        }
        return items[top];
    }

    public void printStaticStack() {
        for (int i = 0; i < top + 1; i++) {
            System.out.print(items[i] + " ");
        }
    }


}
