package estruturadedados.work2.queues;

import java.util.Scanner;

public class Exercise2 {
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
                return;
            }
            this.items[end] = item;
            this.end = (end + 1) % capacity;
            this.numberOfElements++;

        }

        public int dequeue() {
            if (isEmpty()) {
                return -1;
            }
            int removedItem = items[start];
            this.start = (this.start + 1) % capacity;
            this.numberOfElements--;
            return removedItem;
        }



        public int getNumberOfElements() {
            return numberOfElements;
        }

        //Método que retorna o elemento que está associada a posição index
        public int getAt(int index) {
            return items[(this.start + index) % capacity];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int queueSize = input.nextInt();

        StaticQueue staticQueue = new StaticQueue(queueSize);

        for (int i = 0; i < queueSize; i++) {
            staticQueue.enqueue(input.nextInt());
        }

        int numberOfPeopleThatLeftQueue = input.nextInt();
        int[] peoleWhoLeftID = new int[numberOfPeopleThatLeftQueue];

        for (int i = 0; i < numberOfPeopleThatLeftQueue; i++) {
            peoleWhoLeftID[i] = input.nextInt();
        }

        //Nova fila que irá receber os elementos que foram removidos na primeira fila
        StaticQueue newStaticQueue = new StaticQueue(queueSize - numberOfPeopleThatLeftQueue);

        for (int i = 0; i < staticQueue.getNumberOfElements(); i++) {
            int id = staticQueue.getAt(i);
            boolean found = false;

            for (int j = 0; j < numberOfPeopleThatLeftQueue; j++) {
                if (peoleWhoLeftID[j] == id) {
                    found = true;
                    break;
                }

            }
            if (!found) {
                newStaticQueue.enqueue(id);
            }
        }
        for (int i = 0; i < newStaticQueue.getNumberOfElements(); i++) {
            System.out.print(newStaticQueue.getAt(i));
            if (i < newStaticQueue.getNumberOfElements() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
