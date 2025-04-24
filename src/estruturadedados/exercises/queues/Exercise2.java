package estruturadedados.exercises.queues;

import java.util.Scanner;

public class Exercise2 {
    static class StaticQueue {
        private int numberOfElements;
        private int start;
        private int end;
        private int capacity;
        private int[] items;

        public StaticQueue(int cap) {
            this.numberOfElements = 0;
            this.start = 0;
            this.end = 0;
            this.capacity = cap;
            this.items = new int[cap];
        }

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        public boolean isFull() {
            return numberOfElements == capacity;
        }

        public int peek() {
            return items[start];
        }

        public void printQueue() {
            for(int i = 0; i < numberOfElements; i++) {
                int index = (start + i) % capacity;
                System.out.print(items[index]);
                if (i < numberOfElements - 1) {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }

        public void enqueue(int element) throws Exception {
            if (isFull()) {
                throw new Exception("A pilha está cheia");
            }
            this.items[end] = element;
            this.end = (this.end + 1) % capacity;
            this.numberOfElements++;
        }

        public int dequeue() throws Exception {
            if (isEmpty()) {
                throw new Exception("A fila está vazia!");
            }
            int removedElement = this.items[start];
            this.start = (this.start + 1) % capacity;
            this.numberOfElements--;
            return removedElement;

        }
    }

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        StaticQueue staticQueue = new StaticQueue(100);

        System.out.println("Digite um número: ");
        int number = input.nextInt();
        int factor = 2;
        while (number > 1) {
            while (number % factor == 0) {
                staticQueue.enqueue(factor);
                number /= factor;
            }
            factor++;
        }
        staticQueue.printQueue();
    }
}
