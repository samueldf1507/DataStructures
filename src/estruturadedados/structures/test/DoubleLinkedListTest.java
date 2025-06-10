package estruturadedados.structures.test;

import estruturadedados.structures.domain.DoubleLinkedList;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addAtTheStart(5);
        doubleLinkedList.addAtTheStart(10);
        doubleLinkedList.addAtTheStart(12);
        doubleLinkedList.addAtAnyPosition(4, 1);
        doubleLinkedList.printDoubleLinkedList();
    }
}
