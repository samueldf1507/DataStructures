package estruturadedados.work3;

import estruturadedados.structures.domain.DoubleLinkedList;
import estruturadedados.structures.domain.NodeDouble;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Beecrowd1256 {

    static class ListElement {
        int number;
        ListElement nextElement;

        public ListElement(int number) {
            this.number = number;
            this.nextElement = null;
        }
    }

    static class NumberList {
        ListElement firstElement;

        public void addNumber(int number) {
            ListElement newElement = new ListElement(number);

            if (firstElement == null) {
                firstElement = newElement;
            } else {
                ListElement currentElement = firstElement;
                while (currentElement.nextElement != null) {
                    currentElement = currentElement.nextElement;
                }
                currentElement.nextElement = newElement;
            }
        }

        public String createVisualization() {
            StringBuilder visualization = new StringBuilder();
            ListElement currentElement = firstElement;

            while (currentElement != null) {
                visualization.append(" -> ").append(currentElement.number);
                currentElement = currentElement.nextElement;
            }

            return visualization.toString();
        }
    }

    static class HashTableWithChaining {
        NumberList[] buckets;

        public HashTableWithChaining(int numberOfBuckets) {
            buckets = new NumberList[numberOfBuckets];

            for (int i = 0; i < numberOfBuckets; i++) {
                buckets[i] = new NumberList();
            }
        }

        public void addNumber(int number) {
            int bucketIndex = number % buckets.length;
            buckets[bucketIndex].addNumber(number);
        }

        public String showFullTable() {
            StringBuilder result = new StringBuilder();

            for (int bucketNumber = 0; bucketNumber < buckets.length; bucketNumber++) {
                result.append(bucketNumber);
                result.append(buckets[bucketNumber].createVisualization());
                result.append(" -> \\\n");
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numberOfTests = input.nextInt();

        for (int test = 0; test < numberOfTests; test++) {
            int tableSize = input.nextInt();
            int numberOfNumbers = input.nextInt();

            HashTableWithChaining myTable = new HashTableWithChaining(tableSize);

            for (int i = 0; i < numberOfNumbers; i++) {
                int number = input.nextInt();
                myTable.addNumber(number);
            }

            System.out.print(myTable.showFullTable());

            if (test < numberOfTests - 1) {
                System.out.println();
            }
        }
    }
}
