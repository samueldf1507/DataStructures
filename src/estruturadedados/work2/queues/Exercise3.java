package estruturadedados.work2.queues;

import java.util.Scanner;

public class Exercise3 {
    static class StaticQueue{
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

        public void enqueue(int item)  {
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
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int currentFollowers = input.nextInt();
        int mininumFollowers = input.nextInt();

        StaticQueue staticQueue = new StaticQueue(30);
        int sum = 0;

        for (int i = 0; i < 30; i++) {
            int d = input.nextInt();
            staticQueue.enqueue(d);
            sum += d;
        }

        int days = 0;
        while (currentFollowers < mininumFollowers) {
            int avarage = (int) ((sum + 29) / 30);
            currentFollowers += avarage;

            int removed = staticQueue.dequeue();
            sum -= removed;


            staticQueue.enqueue(avarage);
            sum += avarage;

            days++;
        }
        System.out.println(days);

    }
}
