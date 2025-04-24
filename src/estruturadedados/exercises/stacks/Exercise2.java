package estruturadedados.exercises.stacks;

import java.util.Scanner;

public class Exercise2 {
    static class StaticStack {
        private int top;
        private int capacity;
        private int[] items;

        public StaticStack(int cap) {
            this.top = -1;
            this.capacity = cap;
            this.items = new int[cap];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public int showTop() throws Exception {
            if (isEmpty()) {
                throw new Exception("A pilha está vazia");
            }
            return items[top];
        }

        public void push(int element) throws Exception {
            if (isFull()) {
                throw new Exception("A fila está vazia");
            }

            this.top++;
            this.items[top] = element;
        }

        public int pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("A pilha está vazia");
            }

            int removeElement = this.items[top];
            this.top--;
            return removeElement;
        }

        public void printStack() throws Exception {
            if (isEmpty()) {
                throw new Exception("A pilha está vazia!");
            }
            for (int i = 0; i < top + 1; i++) {
                System.out.print(this.items[i] + " ");
            }
        }

        public int getTop() {
            return top;
        }
    }

    public static void main(String[] args) throws Exception {
        StaticStack staticStack = new StaticStack(100);
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 1 + "." + " Número: ");
            int number = input.nextInt();
            if (number % 2 == 0) {
                staticStack.push(number);
            } else {
                if (!staticStack.isEmpty()) {
                    staticStack.pop();
                } else {
                    System.out.println("A pilha está vazia");
                }
            }


        }
        while (!staticStack.isEmpty()) {
            staticStack.pop();
        }
        System.out.println("Número de elementos: " + staticStack.getTop());
    }
}
