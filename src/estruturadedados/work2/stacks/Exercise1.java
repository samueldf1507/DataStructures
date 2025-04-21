package estruturadedados.work2.stacks;
import java.util.Scanner;

public class Exercise1 {
    static class StaticStack {
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

        public void push(char item) {
            if (isFull()) return;
            this.top++;
            items[top] = item;
        }

        public char pop() {
            if (isEmpty()) return ' ';
            char removedItem = items[top];
            this.top--;
            return removedItem;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String expression = input.nextLine();
            StaticStack staticStack = new StaticStack(1000);
            boolean incorrect = false;

            for (int i = 0; i < expression.length(); i++) {
                char character = expression.charAt(i);
                if (character == '(') {
                    staticStack.push(character);
                } else if (character == ')') {
                    if (!staticStack.isEmpty()) {
                        staticStack.pop();
                    } else {
                        incorrect = true;
                        break;
                    }
                }
            }

            if (!incorrect && staticStack.isEmpty()) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
    }
}