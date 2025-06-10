package estruturadedados.work3;

import estruturadedados.structures.domain.DoubleLinkedList;

import estruturadedados.structures.domain.NodeDouble;

import java.util.Scanner;

public class BeeCrowd1257 {
    static class HashTable<T> {
        public DoubleLinkedList<T>[] vector;
        public int numberOfElements;

        public HashTable(int capacity) {
            this.vector = new DoubleLinkedList[capacity];
            for (int i = 0; i < vector.length; i++) {
                this.vector[i] = new DoubleLinkedList<>();

            }
            this.numberOfElements = 0;
        }

        private int hashFunction(T element) {
            return Math.abs(element.hashCode()) % this.vector.length;
        }

        public void insert(T element) {
            int address = hashFunction(element);
            this.vector[address].addAtTheEnd(element);
            this.numberOfElements++;
        }
    }

    static class DoubleLinkedList<T> {
        private Node<T> start;
        private Node<T> end;
        private int numberOfElements;

        public DoubleLinkedList() {
            this.start = null;
            this.end = null;
            this.numberOfElements = 0;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void addAtTheEnd(T element) {
            Node<T> node = new Node<>(element);
            if (this.end == null) {
                this.end = node;
                this.start = node;
            } else {
                this.end.setNext(node);
                node.setLast(this.end);
                this.end = node;
            }
        }

        public Node<T> getStart() {
            return start;
        }
    }

    static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> last;

        public Node(T element) {
            this.last = null;
            this.next = null;
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getLast() {
            return last;
        }

        public void setLast(Node<T> last) {
            this.last = last;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfTests = input.nextInt();
        input.nextLine();

        for (int t = 0; t < numberOfTests; t++) {
            int lines = input.nextInt();
            input.nextLine();

            HashTable<Integer> hash = new HashTable<>(101);

            for (int i = 0; i < lines; i++) {
                String line = input.nextLine();

                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    int position = c - 'A';
                    int value = position + i + j;
                    hash.insert(value);
                }
            }

            int total = 0;
            for (int i = 0; i < hash.vector.length; i++) {
                var list = hash.vector[i];
                var current = list.getStart();
                while (current != null) {
                    total += current.getElement();
                    current = current.getNext();
                }
            }

            System.out.println(total);
        }
    }
}

