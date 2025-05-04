package estruturadedados.work2.stacks;

import java.util.Scanner;

public class Exercise2 {

    static class StaticStack {
        private int top;
        private int[] items;
        private int capacity;



        public StaticStack(int capacity) {
            this.top = -1;
            this.items = new int[capacity];
            this.capacity = capacity;
        }


        public boolean isEmpty() {
            return top == -1;
        }


        public boolean isFull() {
            return top == capacity - 1;
        }


        public int size() {
            return top + 1;
        }


        public void push(int element) {
            if (isFull()) {
                return;
            }

            this.top++;
            this.items[top] = element;
        }


        public int pop() {
            if (isEmpty()) {
                return -1;
            }

            int removedItem = items[top];
            this.top--;
            return removedItem;
        }


        public int top() throws Exception {
            if (isEmpty()) {
                return -1;
            }
            return items[top];
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (true) {
            int numberOfDrivers = input.nextInt();
            int parkingLotCapacity = input.nextInt();

            if (numberOfDrivers == 0 && parkingLotCapacity == 0)
                break;

            StaticStack staticStack = new StaticStack(parkingLotCapacity);
            boolean possible = true;

            for (int i = 0; i < numberOfDrivers; i++) {
                int arriveTime = input.nextInt();
                int leaveTime = input.nextInt();

                while (!staticStack.isEmpty() && staticStack.top() <= arriveTime) {
                    staticStack.pop();
                }
                if (staticStack.isFull()) {
                    possible = false;
                    for (int j = 0; j < numberOfDrivers; j++) {
                        input.nextInt();
                        input.nextInt();
                    }
                    break;
                }
                staticStack.push(leaveTime);
            }
            System.out.println(possible ? "Sim" : "Nao");
        }


    }
}
