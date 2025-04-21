package estruturadedados.work2.stacks;

import java.util.Scanner;

public class Exercise2 {
    static class StaticStack<T> {
        private T[] items;
        private int capacity;
        private int top;

        public StaticStack(int cap) {
            this.items = (T[]) new Object[cap];
            this.capacity = cap;
            this.top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }

        public void push(T item) {
            if (isFull()) return;
            this.top++;
            items[top] = item;
        }

        public T pop() {
            if (isEmpty()) return null;
            T removedItem = items[top];
            this.top--;
            return removedItem;
        }
    }

    static class Car {
        public int arriveTime;
        public int leaveTime;

        public Car(int arriveTime, int leaveTime) {
            this.arriveTime = arriveTime;
            this.leaveTime = leaveTime;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            int numberOfDrivers = input.nextInt();
            int parkingSpace = input.nextInt();
            if (numberOfDrivers == 0 && parkingSpace == 0) {
                break;
            }
        }

        StaticStack<Car> staticStack = new StaticStack(1000);
    }
}


