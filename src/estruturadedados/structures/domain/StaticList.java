package estruturadedados.structures.domain;

public class StaticList {
    public int capacity;
    public int numberOfElements;
    public int[] vector;

    public StaticList(int cap) {
        this.capacity = cap;
        this.vector = new int[cap];
        this.numberOfElements = 0;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == capacity;
    }

    public void printStaticList() {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print(vector[i] + " ");
        }
    }

    public void addAtTheEnd(int element) {
        if (isFull()) {
            System.out.println("A lista está cheia!");
            return;
        }
        this.vector[numberOfElements] = element;
        this.numberOfElements++;

    }

    public void addAtTheStart(int element) {
        if (isFull()) {
            System.out.println("A lista está cheia!");
        }
        for (int i = numberOfElements; i > 0 ; i--) {
            vector[i] = vector[i - 1];
        }
        this.vector[0] = element;
        this.numberOfElements++;
    }

    public int removeAtTheEnd() {
        if (isEmpty()) {
            System.out.println("A lista está vazia!");
        }

        int removedElement = vector[numberOfElements];
        this.numberOfElements--;
        return removedElement;
    }

    public int removeAtTheStart() {
        if (isEmpty()) {
            System.out.println("A lista está ");
        }

        int removedElement = vector[0];
        for (int i = 1; i < numberOfElements; i++) {
            vector[i - 1] = vector[i];
        }
        this.numberOfElements--;
        return removedElement;
    }

    public void addAtAnyPosition(int element, int pos) {
        if (isFull()) {
            System.out.println("A lista está cheia!");
        }

        for (int i = numberOfElements; i > pos; i--) {
            vector[i] = vector[i - 1];
        }

        vector[pos] = element;
        this.numberOfElements++;

    }

    public int removeAtAnyPosition(int pos) {
        if (isEmpty()) {
            System.out.println("A lista está vazia!");
        }

        int removedElement = vector[pos];
        for (int i = pos + 1; i < numberOfElements; i++) {
            vector[i - 1] = vector[i];
        }

        this.numberOfElements--;
        return removedElement;
    }
}
