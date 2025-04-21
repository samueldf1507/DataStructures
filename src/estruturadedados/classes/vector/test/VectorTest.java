package estruturadedados.classes.vector.test;

import estruturadedados.classes.vector.domain.Vector;

import java.util.ArrayList;

public class VectorTest {
    public static void main(String[] args) {
        Vector vector = new Vector(10);
        vector.addAtTheEnd("B");
        vector.addAtTheEnd("C");
        vector.addAtTheEnd("E");
        vector.addAtTheEnd("F");
        vector.addAtTheEnd("G");
        vector.addAtAnyPosition("A", 0);
        vector.addAtAnyPosition("D", 3);
        System.out.println("Tamanho do vetor: " + vector.getSize());

        System.out.println(vector);



    }

}
