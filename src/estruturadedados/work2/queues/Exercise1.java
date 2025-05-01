package estruturadedados.work2.queues;

import java.util.Scanner;

public class Exercise1 {
    static class StaticQueue {
        private int[] items;
        private int capacity;
        private int numberOfElements;
        private int start;
        private int end;

        public StaticQueue(int cap) {
            this.items = new int[cap];
            this.capacity = cap;
            this.numberOfElements = 0;
            this.start = 0;
            this.end = 0;
        }

        public boolean isEmpty() {
            return numberOfElements == 0;
        }

        public boolean isFull() {
            return numberOfElements == capacity;
        }

        public int peek() {
            return this.items[start];
        }

        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("A fila está cheia!");
                return;
            }
            this.items[end] = item;
            this.end = (end + 1) % capacity;
            this.numberOfElements++;
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("A fila está vazia!");
            }
            int removedItem = items[start];
            this.start = (this.start + 1) % capacity;
            this.numberOfElements--;
            return removedItem;
        }

        public int[] toArray() {
            int[] array = new int[numberOfElements];
            for (int i = 0; i < numberOfElements; i++) {
                int index = (start + i) % capacity;
                array[i] = items[index];
            }
            return array;
        }
    }

    public static void sortDescending(int[] vector) {
        int n = vector.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vector[j] < vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfTests = input.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            int numberOfStudents = input.nextInt();

            StaticQueue queue = new StaticQueue(numberOfStudents);
            for (int j = 0; j < numberOfStudents; j++) {
                int element = input.nextInt();
                queue.enqueue(element);
            }

            int[] originalQueue = new int[numberOfStudents];
            for (int j = 0; j < numberOfStudents; j++) {
                originalQueue[j] = queue.dequeue();
            }

            int[] updatedQueue = new int[numberOfStudents];
            for (int j = 0; j < numberOfStudents; j++) {
                updatedQueue[j] = originalQueue[j];
            }
            
            sortDescending(updatedQueue);

            int counter = 0;
            for (int j = 0; j < numberOfStudents; j++) {
                if (originalQueue[j] == updatedQueue[j]) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
}
