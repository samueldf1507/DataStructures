package estruturadedados.structures.test;

import estruturadedados.structures.domain.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAtTheStart(1);
        linkedList.addAtTheStart(0);
        linkedList.addAtTheEnd(2);
        linkedList.addAtTheEnd(3);
        linkedList.addAtTheEnd(4);
        linkedList.addAtTheEnd(5);
        linkedList.printLinkedList(); //Saída: 0, 1, 2, 3, 4, 5
        System.out.println("\nTamanho da lista: " + linkedList.getNumberOfElements());

        System.out.println("-------------");
        System.out.println("1° Atualização da lista...");

        linkedList.removeAtTheStart();
        linkedList.removeAtTheEnd();
        linkedList.printLinkedList(); //Saída: 1, 2, 3, 4
        System.out.println("\nTamanho da lista: " + linkedList.getNumberOfElements());

        System.out.println("-------------");
        System.out.println("2° Atualização da lista...");
        linkedList.addAtAnyPosition(10, 2);
        linkedList.removeAtAnyPosition(0);
        linkedList.printLinkedList(); //Saída:  2, 10, 3, 4



    }
}
